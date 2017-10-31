/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hoantran.lib.utility.json.JsonParser;
import com.github.hoantran.lib.utility.validation.CollectionValidation;
import com.github.hoantran.lib.utility.validation.ObjectValidation;

/**
 * @author hoan.tran
 */
public class FilterProcess {

    public static void removeFilterCriteria(List<FilterCriteria> filterList, String fieldName) {
        List<FilterCriteria> removedList = new ArrayList<FilterCriteria>();
        if (CollectionValidation.isNotEmpty(filterList)) {
            for (FilterCriteria filter : filterList) {
                if (fieldName.equalsIgnoreCase(filter.getKey())) {
                    removedList.add(filter);
                }
            }
            filterList.removeAll(removedList);
        }
    }

    public static List<FilterCriteria> buildFilterCriteria(String json) {
        List<FilterCriteria> filters = JsonParser.converFromJsonToObjectList(FilterCriteria.class, json);
        if (filters == null) {
            filters = new ArrayList<FilterCriteria>();
        }
        return filters;
    }

    /**
     * Combine same key criteria together
     * Example:
     * From: userId = 1, userId = 2
     * To: userId = [1, 2]
     * 
     * @param json
     * @return
     */
    public static Map<String, List<FilterCriteria>> buildFilterCriteriaMap(List<FilterCriteria> filterList) {
        HashMap<String, List<FilterCriteria>> map = new HashMap<String, List<FilterCriteria>>();
        if (ObjectValidation.isValid(filterList)) {
            for (FilterCriteria param : filterList) {
                if (map.containsKey(param.getKey())) {
                    map.get(param.getKey()).add(new FilterCriteria(null, param.getOperator().toString(), param.getValue().toString()));
                } else {
                    List<FilterCriteria> criteria = new ArrayList<FilterCriteria>();
                    criteria.add(new FilterCriteria(null, param.getOperator().toString(), param.getValue()));
                    map.put(param.getKey(), criteria);
                }
            }
        }
        return map;
    }

}
