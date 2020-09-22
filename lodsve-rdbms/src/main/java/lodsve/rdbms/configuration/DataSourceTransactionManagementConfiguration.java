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
package lodsve.rdbms.configuration;

import lodsve.core.condition.ConditionalOnProperty;
import lodsve.rdbms.Constants;
import lodsve.rdbms.properties.RdbmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.lang.NonNull;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * 配置事务.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2016/1/20 11:54
 */
@Configuration
@EnableTransactionManagement
@ConditionalOnProperty(clazz = RdbmsProperties.class, key = "supportTransaction", value = "true")
public class DataSourceTransactionManagementConfiguration implements TransactionManagementConfigurer {
    private final DataSource dataSource;

    @Autowired
    public DataSourceTransactionManagementConfiguration(@Qualifier(Constants.DATA_SOURCE_BEAN_NAME) DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    @NonNull
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
