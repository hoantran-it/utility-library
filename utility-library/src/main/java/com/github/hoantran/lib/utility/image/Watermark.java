/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author HoanTran
 */
public class Watermark {

    public enum PlacementPosition {
        TOPLEFT, TOPCENTER, TOPRIGHT, MIDDLELEFT, MIDDLECENTER, MIDDLERIGHT, BOTTOMLEFT, BOTTOMCENTER, BOTTOMRIGHT
    }

    /**
     * Generate a watermarked image.
     * 
     * @param originalImage
     * @param watermarkImage
     * @param position
     * @param watermarkSizeMaxPercentage
     * @return image with watermark
     * @throws IOException
     */
    public static BufferedImage watermark(BufferedImage originalImage,
            BufferedImage watermarkImage, PlacementPosition position,
            double watermarkSizeMaxPercentage) throws IOException {

        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();

        int watermarkWidth = watermarkImage.getWidth() > originalImage.getWidth() ? originalImage.getWidth() : watermarkImage.getWidth();
        int watermarkHeight = watermarkImage.getHeight() > originalImage.getHeight() ? originalImage.getHeight() : watermarkImage.getHeight();

        // We create a new image because we want to keep the originalImage
        // object intact and not modify it.
        BufferedImage bufferedImage = new BufferedImage(imageWidth,
                imageHeight, ImageScaling.DEFAULT_IMAGE_TYPE);
        Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 0;
        int y = 0;
        if (position != null) {
            switch (position) {
            case TOPLEFT:
                x = 0;
                y = 0;
                break;
            case TOPCENTER:
                x = (imageWidth / 2) - (watermarkWidth / 2);
                y = 0;
                break;
            case TOPRIGHT:
                x = imageWidth - watermarkWidth;
                y = 0;
                break;

            case MIDDLELEFT:
                x = 0;
                y = (imageHeight / 2) - (watermarkHeight / 2);
                break;
            case MIDDLECENTER:
                x = (imageWidth / 2) - (watermarkWidth / 2);
                y = (imageHeight / 2) - (watermarkHeight / 2);
                break;
            case MIDDLERIGHT:
                x = imageWidth - watermarkWidth;
                y = (imageHeight / 2) - (watermarkHeight / 2);
                break;

            case BOTTOMLEFT:
                x = 0;
                y = imageHeight - watermarkHeight;
                break;
            case BOTTOMCENTER:
                x = (imageWidth / 2) - (watermarkWidth / 2);
                y = imageHeight - watermarkHeight;
                break;
            case BOTTOMRIGHT:
                x = imageWidth - watermarkWidth;
                y = imageHeight - watermarkHeight;
                break;

            default:
                break;
            }
        }

        g2d.drawImage(ImageScaling.resizeImageKeepAspectRatio(watermarkImage, watermarkWidth, watermarkHeight, ImageScaling.DEFAULT_IMAGE_FORMAT),
                x, y, null);

        return bufferedImage;
    }

}
