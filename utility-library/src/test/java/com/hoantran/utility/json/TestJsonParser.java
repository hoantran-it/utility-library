/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.utility.json;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hoantran.utility.sampledata.Developer;
import com.hoantran.utility.sampledata.SampleDataCreation;

/**
 * @author hoan.tran
 */
public class TestJsonParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestJsonParser.class);

    @Test
    public void converFromObjectToJson() {
        Developer dev = SampleDataCreation.createOneDeveloper();
        LOGGER.debug(JsonParser.converFromObjectToJson(dev));

    }

    @Test
    public void converFromObjectListToJson() {
        List<Developer> devList = SampleDataCreation.createDeveloperList();
        LOGGER.debug(JsonParser.converFromObjectListToJson(devList));
    }

    @Test
    public void convertFromJsontoObject() {
        String json = "{\"name\":\"Bill\",\"male\":true,\"dateOfBirth\":\"May 24, 2016 5:35:34 PM\",\"experienceYears\":5,\"companyName\":\"Microsoft\"}";
        Developer dev = (Developer) JsonParser.converFromJsonToObject(Developer.class, json);
        SampleDataCreation.printDeveloper(dev);
    }

    @Test
    public void convertFromJsontoObjectList() {
        String json = "[{\"name\":\"Bill\",\"male\":true,\"dateOfBirth\":\"May 25, 2016 10:34:01 AM\",\"experienceYears\":5,\"companyName\":\"Microsoft\"},{\"name\":\"Steven\",\"male\":true,\"dateOfBirth\":\"May 25, 2016 10:34:01 AM\",\"experienceYears\":3,\"companyName\":\"Apple\"}]\n";
        List<Developer> devList = JsonParser.converFromJsonToObjectList(Developer.class, json);
        SampleDataCreation.printDeveloperList(devList);
    }

}
