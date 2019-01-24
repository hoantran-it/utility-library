/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author HoanTran
 */
public class ImageConverter {

    public static InputStream convertPngToJpg(InputStream input) throws Exception {
        BufferedImage image = ImageIO.read(input);
        BufferedImage result = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(result, "jpg", output);

        return new ByteArrayInputStream(output.toByteArray());
    }

}
