/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import com.github.hoantran.lib.utility.image.ImageConstants.ImageExtension;
import com.github.hoantran.lib.utility.image.ImageConstants.ImageIntType;

/**
 * Image scaling.
 * 
 * @author HoanTran
 */
public class ImageScaling {

    public static final boolean KEEP_ASPECT_RATIO = true;

    public static InputStream resizeImage(String imageUrl, int newWidth, int newHeight) throws IOException {
        return resizeImage(new URL(imageUrl).openStream(), newWidth, newHeight, KEEP_ASPECT_RATIO, ImageExtension.DEFAULT_IMAGE_FORMAT);
    }

    public static InputStream resizeImage(String imageUrl, int newWidth, int newHeight, boolean keepAspectRatio) throws IOException {
        return resizeImage(new URL(imageUrl).openStream(), newWidth, newHeight, keepAspectRatio, ImageExtension.DEFAULT_IMAGE_FORMAT);
    }

    public static InputStream resizeImage(String imageUrl, int newWidth, int newHeight,
            boolean keepAspectRatio, String imageFormat) throws IOException {
        return resizeImage(new URL(imageUrl).openStream(), newWidth, newHeight, keepAspectRatio, imageFormat);
    }

    public static InputStream resizeImage(File file, int newWidth, int newHeight) throws IOException {
        return resizeImage(new FileInputStream(file), newWidth, newHeight, KEEP_ASPECT_RATIO, ImageExtension.DEFAULT_IMAGE_FORMAT);
    }

    public static InputStream resizeImage(File file, int newWidth, int newHeight, boolean keepAspectRatio) throws IOException {
        return resizeImage(new FileInputStream(file), newWidth, newHeight, keepAspectRatio, ImageExtension.DEFAULT_IMAGE_FORMAT);
    }

    public static InputStream resizeImage(File file, int newWidth, int newHeight,
            boolean keepAspectRatio, String imageFormat) throws IOException {
        return resizeImage(new FileInputStream(file), newWidth, newHeight, keepAspectRatio, imageFormat);
    }

    public static InputStream resizeImage(InputStream input, int newWidth, int newHeight) throws IOException {
        return resizeImage(input, newWidth, newHeight, KEEP_ASPECT_RATIO, ImageExtension.DEFAULT_IMAGE_FORMAT);
    }

    public static InputStream resizeImage(InputStream input, int newWidth, int newHeight, boolean keepAspectRatio) throws IOException {
        return resizeImage(input, newWidth, newHeight, keepAspectRatio, ImageExtension.DEFAULT_IMAGE_FORMAT);
    }

    public static InputStream resizeImage(InputStream input, int newWidth, int newHeight,
            boolean keepAspectRatio, String imageFormat) throws IOException {
        BufferedImage originalImage = ImageIO.read(input);
        BufferedImage resizedImage = performImageScaling(originalImage, newWidth, newHeight, keepAspectRatio, imageFormat);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, imageFormat, baos);
        return new ByteArrayInputStream(baos.toByteArray());
    }

    public static BufferedImage performImageScaling(BufferedImage originalImage, int newWidth, int newHeight,
            boolean keepAspectRatio, String imageFormat) throws IOException {
        if (keepAspectRatio) {
            return resizeImageKeepAspectRatio(originalImage, newWidth, newHeight, imageFormat);
        } else {
            return resizeImageAbsolutely(originalImage, newWidth, newHeight, imageFormat);
        }
    }

    public static BufferedImage resizeImageKeepAspectRatio(BufferedImage originalImage, int newWidth, int newHeight, String imageFormat) throws IOException {
        double determineImageScale = determineImageScale(originalImage.getWidth(), originalImage.getHeight(), newWidth, newHeight);
        Image scaledImage = originalImage.getScaledInstance((int) (originalImage.getWidth() * determineImageScale),
                (int) (originalImage.getHeight() * determineImageScale), Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null),
                getSuitableImageType(imageFormat));
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(scaledImage, 0, 0, null);
        g.dispose();
        return resizedImage;
    }

    public static BufferedImage resizeImageAbsolutely(BufferedImage originalImage, int newWidth, int newHeight, String imageFormat) throws IOException {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight,
                getSuitableImageType(imageFormat));
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();
        return resizedImage;
    }

    private static double determineImageScale(int sourceWidth, int sourceHeight, int targetWidth, int targetHeight) {
        double scalex = (double) targetWidth / sourceWidth;
        double scaley = (double) targetHeight / sourceHeight;
        return Math.min(scalex, scaley);
    }

    private static int getSuitableImageType(String imageFormat) {
        if (ImageExtension.PNG_FORMAT.equalsIgnoreCase(imageFormat)) {
            return ImageIntType.PNG_IMAGE_TYPE;
        } else if (ImageExtension.JPG_FORMAT.equalsIgnoreCase(imageFormat)) {
            return ImageIntType.JPG_IMAGE_TYPE;
        } else {
            return ImageIntType.DEFAULT_IMAGE_TYPE;
        }
    }

}
