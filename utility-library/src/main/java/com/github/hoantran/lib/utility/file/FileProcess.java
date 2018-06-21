/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.github.hoantran.lib.utility.string.StringManipulation;

/**
 * File process.
 * 
 * @author HoanTran
 */
public class FileProcess {

    public static final String JOINER = "_";

    public static ByteArrayInputStream convertToByteArrInputStream(InputStream input) throws IOException {
        byte[] bytes = IOUtils.toByteArray(input);
        return new ByteArrayInputStream(bytes);
    }

    public static String buildFileName(String fileName, String[] prefixs) {
        return buildFileName(StringManipulation.removeSpecialCharacter(fileName, "."), JOINER, prefixs);
    }

    public static String buildFileName(String fileName, String connector, String[] prefixs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixs.length; i++) {
            if (!prefixs[i].isEmpty()) {
                sb.append(prefixs[i]);
                sb.append(connector);
            }
        }
        sb.append(StringManipulation.removeSpecialCharacter(fileName, "."));
        return sb.toString();
    }

    public static InputStream getInputStreamFromURL(String url) throws Exception {
        return new URL(url).openStream();
    }

}
