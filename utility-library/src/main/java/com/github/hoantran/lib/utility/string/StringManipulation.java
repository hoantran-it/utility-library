/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.string;


/**
 * @author hoan.tran
 */
public class StringManipulation {

    public static String removeSpecialCharacter(String text) {
        return removeSpecialCharacter(text, false);
    }

    public static String removeSpecialCharacter(String text, boolean keepSpace) {
        if (keepSpace) {
            return text.replaceAll("[^a-zA-Z0-9 ]+", "");
        } else {
            return text.replaceAll("[^a-zA-Z0-9]+", "");
        }
    }

}
