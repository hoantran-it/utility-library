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

}
