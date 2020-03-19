/*
 * Copyright (C) 2019 Sun.Hao(https://www.crazy-coder.cn/)
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package lodsve.core;

import lodsve.core.ansi.AnsiColor;
import lodsve.core.ansi.AnsiOutput;
import lodsve.core.ansi.AnsiStyle;
import lodsve.core.configuration.BannerConfig;

import java.io.PrintStream;

/**
 * 默认的banner.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2018/1/12 下午6:31
 */
public class LodsveBanner implements Banner {
    private static final String[] BANNER = new String[]{
            "$$\\                      $$\\                                ",
            "$$ |                     $$ |                               ",
            "$$ |      $$$$$$\\   $$$$$$$ | $$$$$$$\\ $$\\    $$\\  $$$$$$\\  ",
            "$$ |     $$  __$$\\ $$  __$$ |$$  _____|\\$$\\  $$  |$$  __$$\\ ",
            "$$ |     $$ /  $$ |$$ /  $$ |\\$$$$$$\\   \\$$\\$$  / $$$$$$$$ |",
            "$$ |     $$ |  $$ |$$ |  $$ | \\____$$\\   \\$$$  /  $$   ____|",
            "$$$$$$$$\\\\$$$$$$  |\\$$$$$$$ |$$$$$$$  |   \\$  /   \\$$$$$$$\\ ",
            "\\________|\\______/  \\_______|\\_______/     \\_/     \\_______|"
    };

    private static final int LINE_WIDTH = BANNER[0].length();
    private static final String LODSVE_DESCRIPTION = "Let our development of Spring very easy!";
    private static final String LODSVE_TITLE = " :: Lodsve Frameowrk :: ";

    @Override
    public void print(BannerConfig config, PrintStream out) {
        String version = LodsveVersion.getVersion();
        StringBuilder blank1 = new StringBuilder();
        fillBlank(LODSVE_TITLE.length() + version.length(), blank1);

        String builter = "Author: " + LodsveVersion.getBuilter();
        StringBuilder blank2 = new StringBuilder();
        fillBlank(LODSVE_DESCRIPTION.length() + builter.length(), blank2);

        out.println("\n\n\n");
        for (String line : BANNER) {
            out.println(line);
        }

        out.println("\n" + AnsiOutput.toString(AnsiColor.BLUE, LODSVE_DESCRIPTION, AnsiColor.DEFAULT, blank2.toString(), AnsiStyle.FAINT, builter));
        out.println(AnsiOutput.toString(AnsiColor.GREEN, LODSVE_TITLE, AnsiColor.DEFAULT, blank1.toString(), AnsiStyle.FAINT, version));
        out.println("\n\n\n");
    }

    private void fillBlank(int nowLength, StringBuilder blank) {
        if (nowLength < LINE_WIDTH) {
            for (int i = 0; i < LINE_WIDTH - nowLength; i++) {
                blank.append(" ");
            }
        }
    }
}
