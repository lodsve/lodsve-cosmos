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

package lodsve.test.mock.memcached;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.lang.annotation.*;

/**
 * 内嵌式Memcached.
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version V1.0, 2018-1-10-0010 13:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
@TestExecutionListeners({JMemcachedTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public @interface EmbeddedMemcached {
    /**
     * Memcached 端口
     *
     * @return 端口
     */
    int port() default 11211;
}
