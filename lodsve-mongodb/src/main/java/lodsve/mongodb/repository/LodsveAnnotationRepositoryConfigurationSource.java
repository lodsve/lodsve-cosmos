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
package lodsve.mongodb.repository;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Lodsve custom AnnotationRepositoryConfigurationSource.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2017-12-11-0011 14:24
 */
public class LodsveAnnotationRepositoryConfigurationSource extends AnnotationRepositoryConfigurationSource {
    private static final String BASE_PACKAGES = "basePackages";
    private final AnnotationAttributes attributes;
    private final AnnotationMetadata configMetadata;

    /**
     * Creates a new {@link org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource} from the given {@link org.springframework.core.type.AnnotationMetadata} and
     * annotation.
     *
     * @param metadata
     * @param annotation     must not be {@literal null}.
     * @param resourceLoader must not be {@literal null}.
     * @param environment
     */
    public LodsveAnnotationRepositoryConfigurationSource(AnnotationMetadata metadata, Class<? extends Annotation> annotation, ResourceLoader resourceLoader, Environment environment, BeanDefinitionRegistry registry) {
        super(metadata, annotation, resourceLoader, environment, registry);
        this.attributes = new AnnotationAttributes(metadata.getAnnotationAttributes(annotation.getName()));
        this.configMetadata = metadata;
    }

    @Override
    public Iterable<String> getBasePackages() {
        String[] basePackages = attributes.getStringArray(BASE_PACKAGES);

        // Default configuration - return package of annotated class
        if (basePackages.length == 0) {
            String className = configMetadata.getClassName();
            return Collections.singleton(ClassUtils.getPackageName(className));
        }

        return new HashSet<>(Arrays.asList(basePackages));
    }
}
