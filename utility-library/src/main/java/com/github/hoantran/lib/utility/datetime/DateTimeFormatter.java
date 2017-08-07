/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Date time formatter.
 * 
 * @author HoanTran
 */
public class DateTimeFormatter {

    public static String DATE_TIME_POPULAR_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Parse date time from string with given pattern.
     * 
     * @param dateTimeStr
     * @param pattern
     * @return result
     */
    public static Date parseDateTimeFromString(String dateTimeStr, String pattern) {
        Date result = null;
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
            result = dateFormatter.parse(dateTimeStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Format date time to string with given pattern.
     * 
     * @param dateTime
     * @param pattern
     * @return result
     */
    public static String formatDateTimeToString(Date dateTime, String pattern) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        String result = dateFormatter.format(dateTime);
        return result;
    }

    /**
     * Convert local time to GMT time.
     * 
     * @param dateTime
     * @return result
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
     * @return result
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
     * @return result
     */
    public static String convertLocalTimeToGMT(String dateTimeStr, String pattern) {
        Date localDate = parseDateTimeFromString(dateTimeStr, pattern);
        Date gmtDate = convertGMTTimeToLocal(localDate);
        return formatDateTimeToString(gmtDate, pattern);
    }

    /**
     * Convert GMT time to Local.
     * 
     * @param dateTimeStr
     * @param pattern
     * @return
     */
    public static String convertGMTTimeToLocal(String dateTimeStr, String pattern) {
        Date gmtDate = parseDateTimeFromString(dateTimeStr, pattern);
        Date localDate = convertGMTTimeToLocal(gmtDate);
        return formatDateTimeToString(localDate, pattern);
    }
}
