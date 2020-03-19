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

package lodsve.mongodb.connection;

/**
 * 多数据源保存选择的数据源.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2017/12/14 下午6:03
 */
public class MongoDataSourceHolder {
    private static final ThreadLocal<String> DATAS_SOURCE = new ThreadLocal<>();

    public static String get() {
        return DATAS_SOURCE.get();
    }

    static void set(String dataSource) {
        DATAS_SOURCE.set(dataSource);
    }

    static void clear() {
        DATAS_SOURCE.remove();
    }
}
