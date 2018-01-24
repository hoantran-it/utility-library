/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @author hoan.tran
 */
public class StringConcatenation {

    public static String concat(Collection<?> objectList, String fieldName) throws Exception {
        StringBuilder result = new StringBuilder();
        for (Object object : objectList) {
            result.append(getStringValue(object, fieldName));
            result.append(",");
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
