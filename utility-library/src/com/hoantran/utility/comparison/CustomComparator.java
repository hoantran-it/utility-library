/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.comparison;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Custom comparator inherit from Comparator. It can be used to sort with multiple field of object.
 * Easy to extend: all we need to to is extend this class and override getPropertyValue method
 * Default behaviour of getPropertyValue method: get field of object based on field name.
 * 
 * @author HoanTran
 */
public class CustomComparator implements Comparator<Object> {

    private Object[] propertyId;

    private boolean[] ascending;

    /**
     * Every inheritance class must have constructor like this.
     * 
     * @param propertyId
     * @param ascending
     */
    public CustomComparator(Object[] propertyId, boolean[] ascending) {
        super();
        this.propertyId = propertyId;
        this.ascending = ascending;
    }

    /**
     * Compare two objects with multiple fields.
     */
    @Override
    public int compare(Object o1, Object o2) {
        for (int i = 0; i < propertyId.length; i++) {
            int result = compareProperty(propertyId[i], ascending[i],
                    o1, o2);

            // If order can be decided
            if (result != 0) {
                return result;
            }

        }
        return 0;
    }

    /**
     * Compare property. Return compare result.
     * 
     * @param propertyId
     * @param sortDirection
     * @param o1
     * @param o2
     * @return
     */
    protected int compareProperty(Object propertyId, boolean sortDirection,
            Object o1, Object o2) {
        Object value1 = getPropertyValue(o1, propertyId.toString());
        Object value2 = getPropertyValue(o2, propertyId.toString());

        if (sortDirection) {
            // ascending order
            return comparePropertyValue(value1, value2);
        } else {
            // descending order
            return comparePropertyValue(value2, value1);
        }

    }

    /**
     * Get property value from item for comparison.
     * 
     * @param item
     * @param prpoperty
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected Object getPropertyValue(Object item, Object property) {
        Object value = null;
        if (item != null) {
            try {
                Class itemClass = item.getClass();
                Field field = itemClass.getDeclaredField(property.toString());
                field.setAccessible(true);
                value = field.get(item);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    private int comparePropertyValue(Object o1, Object o2) {
        int r = 0;
        // Normal non-null comparison
        if (o1 != null && o2 != null) {
            // Assume the objects can be cast to Comparable, throw
            // ClassCastException otherwise.
            r = ((Comparable<Object>) o1).compareTo(o2);
        } else if (o1 == o2) {
            // Objects are equal if both are null
            r = 0;
        } else {
            if (o1 == null) {
                // null is less than non-null
                r = -1;
            } else {
                // non-null is greater than null
                r = 1;
            }
        }
        return r;
    }
}

