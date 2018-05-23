/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;

import org.apache.commons.lang.RandomStringUtils;

/**
 * @author hoan.tran
 */
public class StringGeneration {

    public static String generateRandomString(int length) throws Exception {
        return RandomStringUtils.random(length, true, true);
    }

    public static String generateRandomLetterString(int length) throws Exception {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomNumberString(int length) throws Exception {
        return RandomStringUtils.randomAlphanumeric(length);
    }

}
