/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility;

import java.util.Collections;
import java.util.List;

import com.hoantran.utility.comparison.CustomComparator;
import com.hoantran.utility.datetime.DateTimeFormatter;
import com.hoantran.utility.sampledata.Developer;
import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author HoanTran
 *
 */
public class UtilityLibrary {

    public static void main(String[] args) {
        // testComparator();
        testDateTime();
    }
    
    public static void testComparator() {
        List<Developer> devList = SampleDataCreation.createSimpleData();
        System.out.println("----- Before sorting -----");
        SampleDataCreation.printSimpleData(devList);
        Object[] propertyId = new Object[] { "name", "experienceYears" };
        boolean[] ascending = new boolean[] { false, false };
        Collections.sort(devList, new CustomComparator(propertyId, ascending));
        System.out.println("----- After sorting -----");
        SampleDataCreation.printSimpleData(devList);
    }

    public static void testDateTime() {
        // Local time to GMT (Date object)
        // Date localTime = new Date();
        // System.out.println("Local:\t" + localTime);
        // Date gmtTime = DateTimeFormatter.convertLocalTimeToGMT(localTime);
        // System.out.println("GMT:\t" + gmtTime);

        // GMT time to Local (Date object)
        // Date gmtTime = new Date();
        // System.out.println("GMT:\t" + gmtTime);
        // Date localTime = DateTimeFormatter.convertGMTTimeToLocal(gmtTime);
        // System.out.println("Local:\t" + localTime);

        // Local time to GMT (String object)
        // String localTime = "2016-05-22 17:16:15";
        // System.out.println("Local:\t" + localTime);
        // String gmtTime = DateTimeFormatter.convertLocalTimeToGMT(localTime, DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        // System.out.println("GMT:\t" + gmtTime);

        // GMT time to Local (String object)
        String gmtTime = "2016-05-22 17:16:15";
        System.out.println("GMT:\t" + gmtTime);
        String localTime = DateTimeFormatter.convertGMTTimeToLocal(gmtTime, DateTimeFormatter.DATE_TIME_POPULAR_FORMAT);
        System.out.println("Local:\t" + localTime);
    }
}
