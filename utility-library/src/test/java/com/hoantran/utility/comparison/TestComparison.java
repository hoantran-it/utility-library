/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.comparison;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hoantran.utility.sampledata.Developer;
import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author hoan.tran
 */
public class TestComparison {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestComparison.class);

    @Test
    public void testComparison() {
        List<Developer> devList = SampleDataCreation.createDeveloperList();
        LOGGER.debug("----- Begin comparison testing -----");
        LOGGER.debug("----- Before sorting -----");
        SampleDataCreation.printDeveloperList(devList);
        Object[] propertyId = new Object[] { "name", "experienceYears" };
        boolean[] ascending = new boolean[] { false, false };
        Collections.sort(devList, new CustomComparator(propertyId, ascending));
        LOGGER.debug("----- After sorting -----");
        SampleDataCreation.printDeveloperList(devList);
        LOGGER.debug("----- End comparison testing -----");
        assertEquals(devList.get(0).getName(), "Steven");
    }
}
