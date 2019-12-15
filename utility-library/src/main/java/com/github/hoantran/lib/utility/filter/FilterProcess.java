/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.hoantran.lib.utility.json.JsonParser;
import com.github.hoantran.lib.utility.validation.CollectionValidation;

/**
 * @author hoan.tran
 */
public class FilterProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterProcess.class);

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
        List<FilterCriteria> filters = null;
        try {
            filters = JsonParser.converFromJsonToObjectList(FilterCriteria.class, json);
        } catch (Exception e) {
            LOGGER.error("Can not build filter criteria. {}", e.getMessage());
        }
        if (filters == null) {
            filters = new ArrayList<FilterCriteria>();
        }
        return filters;
    }

    public static void overrideFilter(List<FilterCriteria> filterList, String fieldName, String fieldValue) {
        Iterator<FilterCriteria> i = filterList.iterator();
        while (i.hasNext()) {
            FilterCriteria filter = i.next();
            if (filter.getKey().equalsIgnoreCase(fieldName)) {
                i.remove();
            }
        }
        FilterCriteria statusFilter = new FilterCriteria(fieldName, null, new String[] { fieldValue });
        filterList.add(statusFilter);
    }

}
