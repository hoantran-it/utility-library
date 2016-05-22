/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.datetime;

import java.text.SimpleDateFormat;

/**
 * @author HoanTran
 *
 */
public class DateTimeFormatter {
    public static String STANDARD_DATE_TIME_FORMAT = "dd/MM/yyyy/ hh:mm:ss";

    public static SimpleDateFormat createDateTimeFormatter(String pattern) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        return dateFormatter;
    }
}
