/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.github.hoantran.lib.utility.image.ImageConstants.ImageExtension;
import com.github.hoantran.lib.utility.image.ImageConstants.ImageIntType;

/**
 * @author HoanTran
 */
public class Watermark {

    public enum PlacementPosition {
        TOPLEFT, TOPCENTER, TOPRIGHT, MIDDLELEFT, MIDDLECENTER, MIDDLERIGHT, BOTTOMLEFT, BOTTOMCENTER, BOTTOMRIGHT
    }

    public static class Coordinates {
        private int x;
        private int y;

        /**
         * @param x
         * @param y
         */
        public Coordinates(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        /**
         * @return the x
         */
        public int getX() {
            return x;
        }

        /**
         * @param x the x to set
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * @return the y
         */
        public int getY() {
            return y;
        }

        /**
         * @param y the y to set
         */
        public void setY(int y) {
            this.y = y;
        }
    }

    public static BufferedImage addImageWatermark(BufferedImage originalImage, PlacementPosition position,
            BufferedImage watermarkImage) throws IOException {

        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();

        int watermarkWidth = watermarkImage.getWidth() > originalImage.getWidth() ? originalImage.getWidth() : watermarkImage.getWidth();
        int watermarkHeight = watermarkImage.getHeight() > originalImage.getHeight() ? originalImage.getHeight() : watermarkImage.getHeight();

        // Keep the original, create new to modify
        BufferedImage watermarked = new BufferedImage(imageWidth, imageHeight, ImageIntType.DEFAULT_IMAGE_TYPE);
        Graphics2D g2d = (Graphics2D) watermarked.getGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Coordinates coordinates = getPosition(position, imageWidth, imageHeight, watermarkWidth, watermarkHeight);

        g2d.drawImage(ImageScaling.resizeImageKeepAspectRatio(watermarkImage, watermarkWidth, watermarkHeight, ImageExtension.DEFAULT_IMAGE_FORMAT),
                coordinates.getX(), coordinates.getY(), null);

        return watermarked;
    }

    public static BufferedImage addTextWatermark(BufferedImage originalImage, PlacementPosition position, String text) throws Exception {
        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();

        // Keep the original, create new to modify
        BufferedImage watermarked = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) watermarked.getGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2d.setComposite(alphaChannel);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

        Coordinates coordinates = getPosition(position, imageWidth, imageHeight, (int) rect.getWidth(), (int) rect.getHeight());

        g2d.drawString(text, coordinates.getX(), coordinates.getY());

        return watermarked;
    }

    private static Coordinates getPosition(PlacementPosition position, int imgWidth, int imgHeight, int watermarkWidth, int watermarkHeight) {
        final int padding = 3;
        int x = padding;
        int y = padding;
        if (position != null) {
            switch (position) {
            case TOPLEFT:
                x = padding;
                y = padding;
                break;
            case TOPCENTER:
                x = (imgWidth / 2) - (watermarkWidth / 2);
                y = padding;
                break;
            case TOPRIGHT:
                x = imgWidth - watermarkWidth - padding;
                y = padding;
                break;

            case MIDDLELEFT:
                x = padding;
                y = (imgHeight / 2) - (watermarkHeight / 2);
                break;
            case MIDDLECENTER:
                x = (imgWidth / 2) - (watermarkWidth / 2);
                y = (imgHeight / 2) - (watermarkHeight / 2);
                break;
            case MIDDLERIGHT:
                x = imgWidth - watermarkWidth - padding;
                y = (imgHeight / 2) - (watermarkHeight / 2);
                break;

            case BOTTOMLEFT:
                x = padding;
                y = imgHeight - watermarkHeight - padding;
                break;
            case BOTTOMCENTER:
                x = (imgWidth / 2) - (watermarkWidth / 2);
                y = imgHeight - watermarkHeight - padding;
                break;
            case BOTTOMRIGHT:
                x = imgWidth - watermarkWidth - padding;
                y = imgHeight - watermarkHeight - padding;
                break;

            default:
                break;
            }
        }
        return new Coordinates(x, y);
    }

}
