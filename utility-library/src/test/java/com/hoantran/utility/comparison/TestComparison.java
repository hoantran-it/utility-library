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
        List<Developer> devList = SampleDataCreation.createSimpleData();
        System.out.println("----- Before sorting -----");
        SampleDataCreation.printSimpleData(devList);
        Object[] propertyId = new Object[] { "name", "experienceYears" };
        boolean[] ascending = new boolean[] { false, false };
        Collections.sort(devList, new CustomComparator(propertyId, ascending));
        System.out.println("----- After sorting -----");
        SampleDataCreation.printSimpleData(devList);
    }
}
