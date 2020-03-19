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

package lodsve.mybatis.configuration;

import lodsve.mybatis.plugins.pagination.PaginationInterceptor;
import lodsve.mybatis.plugins.repository.BaseRepositoryInterceptor;
import lodsve.mybatis.type.TypeHandlerScanner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;

import java.util.Arrays;

/**
 * 扩展mybatis的configuration，加入以下内容：.
 * <ol>
 * <li>字段名和数据库column名符合驼峰命名规范</li>
 * <li>加入两个个插件：分页、通用DAO</li>
 * </ol>
 * 这样就可以省略mybatis的所有基本配置
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 */
public class LodsveConfigurationCustomizer implements ConfigurationCustomizer {
    private boolean mapUnderscoreToCamelCase;
    private String[] enumsLocations;

    public LodsveConfigurationCustomizer(boolean mapUnderscoreToCamelCase, String[] enumsLocations) {
        this.mapUnderscoreToCamelCase = mapUnderscoreToCamelCase;
        this.enumsLocations = enumsLocations;
    }

    @Override
    public void customize(Configuration configuration) {
        configuration.setMapUnderscoreToCamelCase(mapUnderscoreToCamelCase);

        configuration.addInterceptor(new PaginationInterceptor());
        configuration.addInterceptor(new BaseRepositoryInterceptor());

        if (ArrayUtils.isNotEmpty(enumsLocations)) {
            TypeHandler<?>[] handlers = new TypeHandlerScanner().find(enumsLocations);
            Arrays.stream(handlers).forEach(configuration.getTypeHandlerRegistry()::register);
        }
    }
}
