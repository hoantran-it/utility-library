/**
 * This file Copyright (c) 2016 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This program and the accompanying materials are made
 * available under the terms of the Magnolia Network Agreement
 * which accompanies this distribution, and is available at
 * http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package com.hoantran.utility.datetime;

import java.util.Date;

import org.junit.Test;

import com.hoantran.utility.datetime.DateTimeCalculation;
import com.hoantran.utility.datetime.DateTimeCalculation.DateTimeResult;
import com.hoantran.utility.datetime.DateTimeFormatter;

/**
 * @author hoan.tran
 */
public class TestDateTime {

    @Test
    public void convertLocalTimeToGMT_Object() {
        // Local time to GMT (Date object)
        Date localTime = new Date();
        System.out.println("Local:\t" + localTime);
        Date gmtTime = DateTimeFormatter.convertLocalTimeToGMT(localTime);
        System.out.println("GMT:\t" + gmtTime);
    }

    @Test
    public void convertGMTTimeToLocal_Object() {
        // GMT time to Local (Date object)
        Date gmtTime = new Date();
        System.out.println("GMT:\t" + gmtTime);
        Date localTime = DateTimeFormatter.convertGMTTimeToLocal(gmtTime);
        System.out.println("Local:\t" + localTime);
    }

    @Test
    public void convertLocalTimeToGMT_String() {
        // Local time to GMT (String object)
        String localTime = "2016-05-22 17:16:15";
        System.out.println("Local:\t" + localTime);
        String gmtTime = DateTimeFormatter.convertLocalTimeToGMT(localTime, DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        System.out.println("GMT:\t" + gmtTime);
    }

    @Test
    public void convertGMTTimeToLocal_String() {
        // GMT time to Local (String object)
        String gmtTime = "2016-05-22 17:16:15";
        System.out.println("GMT:\t" + gmtTime);
        String localTime = DateTimeFormatter.convertGMTTimeToLocal(gmtTime, DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        System.out.println("Local:\t" + localTime);
    }

    @Test
    public void calculateDifference() {
        // Calculate difference between 2 date
        String date1 = "2016-05-22 07:16:15";
        String date2 = "2016-06-22 19:19:15";
        DateTimeResult result = DateTimeCalculation.calculateDifference(date1, date2,
                DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        System.out.println("Date time difference days:\t" + result.getDiffDays());
        System.out.println("Date time difference hours:\t" + result.getDiffHours());
        System.out.println("Date time difference minutes:\t" + result.getDiffMinutes());
        System.out.println("Date time difference seconds:\t" + result.getDiffSeconds());
    }
}
