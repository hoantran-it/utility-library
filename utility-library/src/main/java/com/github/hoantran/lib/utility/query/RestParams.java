/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Rest params util.
 * 
 * @author HoanTran
 */
public class RestParams {

    public static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";

    /**
     * Build query params.
     * 
     * @param queryMap
     * @return example name=abc&id=123
     * @throws UnsupportedEncodingException
     */
    public static String buildQueryParams(Map<String, String> queryMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<String, String> e : queryMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(URLEncoder.encode(e.getKey(), DEFAULT_CHARACTER_ENCODING)).append('=').append(URLEncoder.encode(e.getValue(), DEFAULT_CHARACTER_ENCODING));
        }
        // Reference: https://stackoverflow.com/questions/14357970/java-library-for-url-encoding-if-necessary-like-a-browser
        return sb.toString().replaceAll("%2C", ",");
    }

}
