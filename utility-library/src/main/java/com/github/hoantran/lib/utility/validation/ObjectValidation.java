/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.validation;


/**
 * @author hoan.tran
 */
public class ObjectValidation {

    public static boolean isValid(Object item) {
        return item == null ? false : true;
    }

    public static boolean isNotValid(Object item) {
        return !isValid(item);
    }

    public static boolean isValidString(Object item) {
        if(isNotValid(item)) return false;
        if (item instanceof String) {
            if (String.valueOf(item).length() == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
