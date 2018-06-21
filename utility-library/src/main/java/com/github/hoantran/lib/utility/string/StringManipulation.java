/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;

import org.apache.commons.lang.StringUtils;

/**
 * @author hoan.tran
 */
public class StringManipulation {

    public static String removeSpecialCharacter(String text) {
        return removeSpecialCharacter(text, StringUtils.EMPTY);
    }

    public static String removeSpecialCharacter(String text, String keepCharacterList) {
        return text.replaceAll("[^a-zA-Z0-9" + keepCharacterList + "]+", "");
    }

}
