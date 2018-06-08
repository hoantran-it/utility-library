/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.converter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author hoan.tran
 */
public class TestConverter {

    @Test
    public void convertEmptyStringToBigDecimal() {
        BigDecimal num = ObjectConverter.getBigDecimal("");
        assertEquals(BigDecimal.ZERO, num);
    }

    @Test
    public void convertInvalidStringToBigDecimal() {
        BigDecimal num = ObjectConverter.getBigDecimal("abc");
        assertEquals(BigDecimal.ZERO, num);
    }

}
