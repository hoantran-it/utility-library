/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author hoan.tran
 */
public class StringConcatenation {

    private final static String DEFAULT_CONNECTOR = ",";

    public static String concat(Collection<?> objectList, String fieldName) throws Exception {
        StringBuilder result = new StringBuilder();
        for (Object object : objectList) {
            result.append(getStringValue(object, fieldName));
            result.append(DEFAULT_CONNECTOR);
        }
        return result.toString();
    }

    public static String concat(Collection<?> objectList, String fieldName, String connector) throws Exception {
        StringBuilder result = new StringBuilder();
        for (Object object : objectList) {
            result.append(getStringValue(object, fieldName));
            result.append(connector);
        }
        return result.toString();
    }

    public static List<String> split(String stringList) throws Exception {
        if (stringList == null || stringList.isEmpty()) {
            return new ArrayList<String>();
        }
        return Arrays.asList(stringList.split(DEFAULT_CONNECTOR));
    }

    public static List<String> split(String stringList, String connector) throws Exception {
        return Arrays.asList(stringList.split(connector));
    }

    @SuppressWarnings("rawtypes")
    protected static String getStringValue(Object item, String fieldName) throws Exception {
        String value = "";
        if (item != null) {
            Class itemClass = item.getClass();
            Field field = itemClass.getDeclaredField(fieldName);
            if (field.getType() == String.class) {
                field.setAccessible(true);
                value = (String) field.get(item);
            }
        }
        return value;
    }

}
