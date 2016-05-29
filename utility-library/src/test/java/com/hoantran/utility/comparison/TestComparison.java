/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.comparison;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.hoantran.utility.sampledata.Developer;
import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author hoan.tran
 */
public class TestComparison {

    @Test
    public void testComparison() {
        List<Developer> devList = SampleDataCreation.createDeveloperList();
        System.out.println("----- Before sorting -----");
        SampleDataCreation.printDeveloperList(devList);
        Object[] propertyId = new Object[] { "name", "experienceYears" };
        boolean[] ascending = new boolean[] { false, false };
        Collections.sort(devList, new CustomComparator(propertyId, ascending));
        System.out.println("----- After sorting -----");
        SampleDataCreation.printDeveloperList(devList);
    }
}
