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

package lodsve.rabbitmq.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认异常处理.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2014-10-7 13:18
 */
public class DefaultRabbitErrorHandler extends RabbitErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultRabbitErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        logger.error("RabbitMQ happen a error:" + t.getMessage(), t);
    }
}
