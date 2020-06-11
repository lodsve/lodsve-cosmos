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

package lodsve.rdbms.properties;

import lodsve.core.autoproperties.relaxedbind.annotations.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * rdbms base properties,only support BasicDataSource and DruidDataSource.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2016-1-27 09:20
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "lodsve.rdbms", locations = "${params.root}/framework/rdbms.properties")
public class RdbmsProperties {
    /**
     * 数据源类型
     */
    private String dataSourceClass = "org.apache.commons.dbcp.BasicDataSource";
    /**
     * 是否支持事务
     */
    private boolean supportTransaction = false;
    /**
     * 连接信息
     */
    private Map<String, PoolSetting> pool;
}
