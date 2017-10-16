/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.util.IOUtils;

/**
 * File process.
 * 
 * @author HoanTran
 */
public class FileProcess {

    public static final String JOINER = "_";

    public static ByteArrayInputStream convertToByteArrInputStream(InputStream input) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(input, baos);
        byte[] bytes = baos.toByteArray();
        return new ByteArrayInputStream(bytes);
    }

    public static String buildFileName(String fileName, String[] prefixs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixs.length; i++) {
            if (!prefixs[i].isEmpty()) {
                sb.append(prefixs[i]);
                sb.append(JOINER);
            }
        }
        sb.append(fileName);
        return sb.toString();
    }

    public static String buildFileName(String fileName, String connector, String[] prefixs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixs.length; i++) {
            sb.append(prefixs[i]);
            sb.append(connector);
        }
        sb.append(fileName);
        return sb.toString();
    }

}
