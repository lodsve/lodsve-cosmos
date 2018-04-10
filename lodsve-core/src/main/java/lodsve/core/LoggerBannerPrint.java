/*
 * Copyright (C) 2018  Sun.Hao
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @date 2018-4-10-0010 14:46
 */
public class LoggerBannerPrint implements BannerPrint {
    private static final Logger logger = LoggerFactory.getLogger(LoggerBannerPrint.class);

    @Override
    public void print(String text) {
        if (logger.isInfoEnabled()) {
            logger.info(text);
        }
    }

    @Override
    public void println(String text) {
        if (logger.isInfoEnabled()) {
            logger.info(text + "\n");
        }
    }

    @Override
    public void println() {
        if (logger.isInfoEnabled()) {
            logger.info("\n");
        }
    }
}
