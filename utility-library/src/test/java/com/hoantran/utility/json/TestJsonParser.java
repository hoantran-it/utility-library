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
package com.hoantran.utility.json;

import org.junit.Test;

import com.hoantran.utility.sampledata.Developer;
import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author hoan.tran
 */
public class TestJsonParser {

    @Test
    public void converFromObjectToJson() {
        Developer dev = SampleDataCreation.createOneDeveloper();
        System.out.println(JsonParser.converFromObjectToJson(dev));
    }

    @Test
    public void convertFromJsontoObject() {
        String json = "{\"name\":\"Bill\",\"male\":true,\"dateOfBirth\":\"May 24, 2016 5:35:34 PM\",\"experienceYears\":5,\"companyName\":\"Microsoft\"}";
        Developer dev = (Developer) JsonParser.converFromJsonToObject(Developer.class, json);
        SampleDataCreation.printDeveloper(dev);
    }
}
