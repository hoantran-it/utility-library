/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.converter;

import java.math.BigDecimal;

/**
 * @author hoan.tran
 */
public class ObjectConverter {

    public static Object getTrueType(String value) {
        if (Boolean.TRUE.toString().equalsIgnoreCase(value) || Boolean.FALSE.toString().equalsIgnoreCase(value)) {
            return Boolean.parseBoolean(value);
        }
        return value;
    }

    public static BigDecimal getBigDecimal(String value) {
        try {
            return BigDecimal.valueOf(Double.parseDouble(value));
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

}
