/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author HoanTran
 *
 */
public class DateTimeFormatter {

    public static String DATE_TIME_POPULAR_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Create date time formatter based on given pattern.
     * 
     * @param pattern
     * @return
     */
    public static SimpleDateFormat createDateTimeFormatter(String pattern) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        return dateFormatter;
    }

    /**
     * Convert local time to GMT time.
     * 
     * @param dateTime
     * @return
     */
    public static Date convertLocalTimeToGMT(Date dateTime) {
        TimeZone timeZone = TimeZone.getDefault();
        Date gmtDateTime = new Date(dateTime.getTime() - timeZone.getRawOffset());
        // If we are now in DST, back off by the delta. Note that we are checking the GMT date, this is the KEY.
        if (timeZone.inDaylightTime(gmtDateTime)) {
            Date dstDate = new Date(gmtDateTime.getTime() - timeZone.getDSTSavings());

            // Check to make sure we have not crossed back into standard time
            // This happens when we are on the cusp of DST (7pm the day before the change for PDT)
            if (timeZone.inDaylightTime(dstDate)) {
                gmtDateTime = dstDate;
            }
        }
        return gmtDateTime;
    }

    /**
     * Convert GMT time to Local.
     * 
     * @param dateTime
     * @return
     */
    public static Date convertGMTTimeToLocal(Date dateTime) {
        TimeZone timeZone = TimeZone.getDefault();
        Date localDateTime = new Date(dateTime.getTime() + timeZone.getRawOffset());
        // If we are now in DST, back off by the delta. Note that we are checking the GMT date, this is the KEY.
        if (timeZone.inDaylightTime(localDateTime)) {
            Date dstDate = new Date(localDateTime.getTime() + timeZone.getDSTSavings());

            // Check to make sure we have not crossed back into standard time
            // This happens when we are on the cusp of DST (7pm the day before the change for PDT)
            if (timeZone.inDaylightTime(dstDate)) {
                localDateTime = dstDate;
            }
        }
        return localDateTime;
    }

    /**
     * Convert local time to GMT time.
     * 
     * @param dateTimeStr
     * @param pattern
     * @return
     */
    public static String convertLocalTimeToGMT(String dateTimeStr, String pattern) {
        SimpleDateFormat sdf = createDateTimeFormatter(pattern);
        String result = "";
        try {
            Date localDate = sdf.parse(dateTimeStr);
            Date gmtDate = convertLocalTimeToGMT(localDate);
            result = sdf.format(gmtDate);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return result;
    }

    /**
     * Convert GMT time to Local.
     * 
     * @param dateTimeStr
     * @param pattern
     * @return
     */
    public static String convertGMTTimeToLocal(String dateTimeStr, String pattern) {
        SimpleDateFormat sdf = createDateTimeFormatter(pattern);
        String result = "";
        try {
            Date gmtDate = sdf.parse(dateTimeStr);
            Date localDate = convertGMTTimeToLocal(gmtDate);
            result = sdf.format(localDate);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return result;
    }
}
