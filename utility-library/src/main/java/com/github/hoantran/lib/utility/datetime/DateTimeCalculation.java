/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.datetime;

import java.util.Date;

/**
 * Date time calculation.
 * 
 * @author HoanTran
 */
public class DateTimeCalculation {

    /**
     * Calculate difference between 2 dates
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static DateTimeResult calculateDifference(Date date1, Date date2) {
        DateTimeResult result = new DateTimeResult();
        long diff = date2.getTime() - date1.getTime();
        result.setDiffSeconds(diff / 1000 % 60);
        result.setDiffMinutes(diff / (60 * 1000) % 60);
        result.setDiffHours(diff / (60 * 60 * 1000) % 24);
        result.setDiffDays(diff / (24 * 60 * 60 * 1000));
        return result;
    }

    /**
     * Calculate difference between 2 date string with same pattern
     * 
     * @param dateStr1
     * @param dateStr2
     * @param pattern
     * @return
     */
    public static DateTimeResult calculateDifference(String dateStr1, String dateStr2, String pattern) {
        Date date1 = DateTimeFormatter.parseDateTimeFromString(dateStr1, pattern);
        Date date2 = DateTimeFormatter.parseDateTimeFromString(dateStr2, pattern);
        return calculateDifference(date1, date2);
    }

    public static class DateTimeResult {

        private long diffDays;
        private long diffHours;
        private long diffMinutes;
        private long diffSeconds;

        /**
         * @return the diffDays
         */
        public long getDiffDays() {
            return diffDays;
        }

        /**
         * @param diffDays the diffDays to set
         */
        public void setDiffDays(long diffDays) {
            this.diffDays = diffDays;
        }

        /**
         * @return the diffHours
         */
        public long getDiffHours() {
            return diffHours;
        }

        /**
         * @param diffHours the diffHours to set
         */
        public void setDiffHours(long diffHours) {
            this.diffHours = diffHours;
        }

        /**
         * @return the diffMinutes
         */
        public long getDiffMinutes() {
            return diffMinutes;
        }

        /**
         * @param diffMinutes the diffMinutes to set
         */
        public void setDiffMinutes(long diffMinutes) {
            this.diffMinutes = diffMinutes;
        }

        /**
         * @return the diffSeconds
         */
        public long getDiffSeconds() {
            return diffSeconds;
        }

        /**
         * @param diffSeconds the diffSeconds to set
         */
        public void setDiffSeconds(long diffSeconds) {
            this.diffSeconds = diffSeconds;
        }

    }
}
