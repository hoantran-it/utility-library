/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

/**
 * @author hoan.tran
 */
public class TestStringConcatenation {

    @Test
    public void testSplit() throws Exception {
        List<String> strList = StringConcatenation.split("one,two,three", ",");
        assertTrue(strList.get(0).toString().equals("one"));
        assertTrue(strList.get(1).toString().equals("two"));
        assertTrue(strList.get(2).toString().equals("three"));
    }

    @Test
    public void testRemoveSpecialCharacter() throws UnsupportedEncodingException {
        String text = "chuỗi ký tự đặc biệt.jpg";
        assertTrue(StringManipulation.removeSpecialCharacter(text).equals("chuiktcbitjpg"));
        assertTrue(StringManipulation.removeSpecialCharacter(text, " .").equals("chui k t c bit.jpg"));
    }

}
