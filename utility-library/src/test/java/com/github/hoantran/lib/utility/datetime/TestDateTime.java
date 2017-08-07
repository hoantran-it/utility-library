/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.datetime;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.hoantran.lib.utility.datetime.DateTimeCalculation;
import com.github.hoantran.lib.utility.datetime.DateTimeFormatter;
import com.github.hoantran.lib.utility.datetime.DateTimeCalculation.DateTimeResult;

/**
 * @author hoan.tran
 */
public class TestDateTime {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestDateTime.class);

    @Test
    public void convertLocalTimeToGMT_Object() {
        // Local time to GMT (Date object)
        Date localTime = new Date();
        LOGGER.debug("Local:\t" + localTime);
        Date gmtTime = DateTimeFormatter.convertLocalTimeToGMT(localTime);
        LOGGER.debug("GMT:\t" + gmtTime);
    }

    @Test
    public void convertGMTTimeToLocal_Object() {
        // GMT time to Local (Date object)
        Date gmtTime = new Date();
        LOGGER.debug("GMT:\t" + gmtTime);
        Date localTime = DateTimeFormatter.convertGMTTimeToLocal(gmtTime);
        LOGGER.debug("Local:\t" + localTime);
    }

    @Test
    public void convertLocalTimeToGMT_String() {
        // Local time to GMT (String object)
        String localTime = "2016-05-22 17:16:15";
        LOGGER.debug("Local:\t" + localTime);
        String gmtTime = DateTimeFormatter.convertLocalTimeToGMT(localTime, DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        LOGGER.debug("GMT:\t" + gmtTime);
    }

    @Test
    public void convertGMTTimeToLocal_String() {
        // GMT time to Local (String object)
        String gmtTime = "2016-05-22 17:16:15";
        LOGGER.debug("GMT:\t" + gmtTime);
        String localTime = DateTimeFormatter.convertGMTTimeToLocal(gmtTime, DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        LOGGER.debug("Local:\t" + localTime);
    }

    @Test
    public void calculateDifference() {
        // Calculate difference between 2 date
        String date1 = "2016-05-22 07:16:15";
        String date2 = "2016-06-22 19:19:15";
        DateTimeResult result = DateTimeCalculation.calculateDifference(date1, date2,
                DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        LOGGER.debug("Date time difference days:\t" + result.getDiffDays());
        LOGGER.debug("Date time difference hours:\t" + result.getDiffHours());
        LOGGER.debug("Date time difference minutes:\t" + result.getDiffMinutes());
        LOGGER.debug("Date time difference seconds:\t" + result.getDiffSeconds());
    }
}
