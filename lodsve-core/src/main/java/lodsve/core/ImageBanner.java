/*
 * Copyright © 2009 Sun.Hao(https://www.crazy-coder.cn/)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package lodsve.core;

import lodsve.core.ansi.*;
import lodsve.core.configuration.properties.BannerConfig;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * image banner.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2018-1-18-0018 10:06
 */
public class ImageBanner implements Banner {
    private static final double[] RGB_WEIGHT = {0.2126d, 0.7152d, 0.0722d};
    private static final char[] PIXEL = {' ', '.', '*', ':', 'o', '&', '8', '#', '@'};
    private static final int LUMINANCE_INCREMENT = 10;
    private static final int LUMINANCE_START = LUMINANCE_INCREMENT * PIXEL.length;

    private final Resource resource;

    ImageBanner(Resource resource) {
        Assert.notNull(resource, "Image must not be null");
        Assert.isTrue(resource.exists(), "Image must exist");

        this.resource = resource;
    }

    @Override
    public void print(BannerConfig config, PrintStream out) {
        int width = config.getImage().getWidth(), height = config.getImage().getHeight(), margin = config.getImage().getMargin();
        String headless = System.getProperty("java.awt.headless");
        try {
            System.setProperty("java.awt.headless", "true");
            BufferedImage image = readImage(width, height);
            printBanner(image, margin, config.getImage().isInvert(), out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (headless == null) {
                System.clearProperty("java.awt.headless");
            } else {
                System.setProperty("java.awt.headless", headless);
            }
        }
    }

    private BufferedImage readImage(int width, int height) throws IOException {
        try (InputStream inputStream = resource.getInputStream()) {
            BufferedImage image = ImageIO.read(inputStream);
            return resizeImage(image, width, height);
        }
    }

    private BufferedImage resizeImage(BufferedImage image, int width, int height) {
        if (width < 1) {
            width = 1;
        }
        if (height <= 0) {
            double aspectRatio = (double) width / image.getWidth() * 0.5;
            height = (int) Math.ceil(image.getHeight() * aspectRatio);
        }
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Image scaled = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        resized.getGraphics().drawImage(scaled, 0, 0, null);
        return resized;
    }

    private void printBanner(BufferedImage image, int margin, boolean invert, PrintStream out) {
        AnsiElement background = (invert ? AnsiBackground.BLACK : AnsiBackground.DEFAULT);
        out.print(AnsiOutput.encode(AnsiColor.DEFAULT));
        out.print(AnsiOutput.encode(background));
        out.println();
        out.println();
        AnsiColor lastColor = AnsiColor.DEFAULT;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int i = 0; i < margin; i++) {
                out.print(" ");
            }
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = new Color(image.getRGB(x, y), false);
                AnsiColor ansiColor = AnsiColors.getClosest(color);
                if (ansiColor != lastColor) {
                    out.print(AnsiOutput.encode(ansiColor));
                    lastColor = ansiColor;
                }
                out.print(getAsciiPixel(color, invert));
            }
            out.println();
        }
        out.print(AnsiOutput.encode(AnsiColor.DEFAULT));
        out.print(AnsiOutput.encode(AnsiBackground.DEFAULT));
        out.println();
    }

    private char getAsciiPixel(Color color, boolean dark) {
        double luminance = getLuminance(color, dark);
        for (int i = 0; i < PIXEL.length; i++) {
            if (luminance >= (LUMINANCE_START - (i * LUMINANCE_INCREMENT))) {
                return PIXEL[i];
            }
        }
        return PIXEL[PIXEL.length - 1];
    }

    private int getLuminance(Color color, boolean inverse) {
        double luminance = 0.0;
        luminance += getLuminance(color.getRed(), inverse, RGB_WEIGHT[0]);
        luminance += getLuminance(color.getGreen(), inverse, RGB_WEIGHT[1]);
        luminance += getLuminance(color.getBlue(), inverse, RGB_WEIGHT[2]);
        return (int) Math.ceil((luminance / 0xFF) * 100);
    }

    private double getLuminance(int component, boolean inverse, double weight) {
        return (inverse ? 0xFF - component : component) * weight;
    }

}
