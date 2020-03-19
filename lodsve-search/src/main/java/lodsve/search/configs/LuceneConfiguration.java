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

package lodsve.search.configs;

import lodsve.core.properties.relaxedbind.annotations.EnableConfigurationProperties;
import lodsve.search.engine.LuceneSearchEngine;
import lodsve.search.engine.SearchEngine;
import lodsve.search.properties.LuceneConfig;
import lodsve.search.properties.SearchProperties;
import org.apache.lucene.analysis.Analyzer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * lucene配置.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2016/1/20 12:33
 */
@Configurable
@EnableConfigurationProperties(SearchProperties.class)
@ComponentScan("lodsve.search")
public class LuceneConfiguration {
    @Autowired
    private SearchProperties properties;

    @Bean
    public SearchEngine searchEngine() {
        LuceneConfig lucene = properties.getLucene();

        Class<?> analyzerClass = lucene.getAnalyzer();
        Analyzer analyzer = (Analyzer) BeanUtils.instantiate(analyzerClass);

        return new LuceneSearchEngine(lucene.getIndex(), analyzer, lucene.getPrefix(), lucene.getSuffix());
    }
}
