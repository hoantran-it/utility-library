/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.query;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hoan.tran
 */
public class TestRestParams {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRestParams.class);

    @Test
    public void buildQueryParamsFromMap() throws UnsupportedEncodingException {
        Map<String, String> queryMap = new HashMap<String, String>();
        queryMap.put("name", "abc");
        queryMap.put("id", "123");
        String queryStr = RestParams.buildQueryParams(queryMap);
        assertEquals(queryStr, "name=abc&id=123");
    }

}
