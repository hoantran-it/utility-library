/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.validation;

import org.apache.commons.lang.StringUtils;

/**
 * @author hoan.tran
 */
public class NumberValidation {

    public static boolean isNumber(String strNumber) {
        return StringUtils.isNumeric(strNumber);
    }
}
