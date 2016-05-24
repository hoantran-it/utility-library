/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.sampledata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HoanTran
 */
public class SampleDataCreation {

    public static List<Developer> createSimpleData() {

        List<Developer> devList = new ArrayList<Developer>();
        Developer dev = new Developer();

        dev.setName("Bill");
        dev.setMale(true);
        dev.setDateOfBirth(new Date());
        dev.setExperienceYears(5);
        dev.setCompanyName("Microsoft");
        devList.add(dev);

        dev = new Developer();
        dev.setName("Steven");
        dev.setMale(true);
        dev.setDateOfBirth(new Date());
        dev.setExperienceYears(3);
        dev.setCompanyName("Apple");
        devList.add(dev);

        return devList;

    }

    public static void printSimpleData(List<Developer> devList) {
        for (Developer dev : devList) {
            System.out.println(String.format("%s\t%s\t%s\t%s\t%s",
                    dev.getName(), dev.getMale(), dev.getDateOfBirth(), dev.getExperienceYears(), dev.getCompanyName()));
        }
    }
}
