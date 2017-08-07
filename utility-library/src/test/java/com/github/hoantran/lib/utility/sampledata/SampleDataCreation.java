/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.sampledata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.hoantran.lib.utility.sql.QueryCriteria;

/**
 * @author HoanTran
 */
public class SampleDataCreation {

    public static List<Developer> createDeveloperList() {

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

    public static void printDeveloperList(List<Developer> devList) {
        for (Developer dev : devList) {
            printDeveloper(dev);
        }
    }

    public static void printDeveloper(Developer dev) {
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s",
                dev.getName(), dev.getMale(), dev.getDateOfBirth(), dev.getExperienceYears(), dev.getCompanyName()));
    }

    public static Developer createOneDeveloper() {
        Developer dev = new Developer();
        dev.setName("Bill");
        dev.setMale(true);
        dev.setDateOfBirth(new Date());
        dev.setExperienceYears(5);
        dev.setCompanyName("Microsoft");
        return dev;
    }

    public static List<QueryCriteria> createQueryCriteriaList() {
        List<String> values = new ArrayList<String>();
        values.add("value 1");
        values.add("value 2");
        values.add("value 3");

        List<QueryCriteria> criteriaList = new ArrayList<QueryCriteria>();

        QueryCriteria criteria = new QueryCriteria();
        criteria.setField("address");
        criteria.setOperator("=");
        criteria.setValues(values);
        criteriaList.add(criteria);

        criteria = new QueryCriteria();
        criteria.setField("name");
        criteria.setOperator("=");
        criteria.setValues(values);
        criteriaList.add(criteria);

        return criteriaList;

    }
}
