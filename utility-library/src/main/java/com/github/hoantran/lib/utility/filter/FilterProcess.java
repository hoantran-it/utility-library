/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.filter;

import java.util.ArrayList;
import java.util.List;

import com.github.hoantran.lib.utility.json.JsonParser;
import com.github.hoantran.lib.utility.validation.CollectionValidation;

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

}
