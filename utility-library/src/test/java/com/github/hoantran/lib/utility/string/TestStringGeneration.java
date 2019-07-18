/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author hoan.tran
 */
public class TestStringGeneration {

    @Test
    public void testGenerateOrderNumber() throws Exception {
        assertEquals(StringGeneration.generateOrderNumber(14).length(), 17);
        assertEquals(StringGeneration.generateOrderNumber(15).length(), 18);
        assertEquals(StringGeneration.generateOrderNumber(16).length(), 19);
        assertEquals(StringGeneration.generateOrderNumber(17).length(), 20);
        assertEquals(StringGeneration.generateOrderNumber(18).length(), 21);
        assertEquals(StringGeneration.generateOrderNumber(19).length(), 22);
        assertEquals(StringGeneration.generateOrderNumber(20).length(), 23);
    }

}
