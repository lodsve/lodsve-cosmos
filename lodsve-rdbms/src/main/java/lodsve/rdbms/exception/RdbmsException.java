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

package lodsve.rdbms.exception;

import lodsve.core.exception.ApplicationException;

/**
 * rdbms异常.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 16/8/15 下午4:10
 */
public class RdbmsException extends ApplicationException {
    public RdbmsException(String content) {
        super(content);
    }

    public RdbmsException(Integer code, String content) {
        super(code, content);
    }

    public RdbmsException(Integer code, String content, String... args) {
        super(code, content, args);
    }
}
