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
package lodsve.core.utils;

import lodsve.core.io.ZookeeperResource;
import lodsve.core.io.support.LodsveResourceLoader;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * resource utils.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2018/1/6 上午1:34
 */
public final class ResourceUtils {
    private static final ResourceLoader RESOURCE_LOADER = new LodsveResourceLoader();

    private ResourceUtils() {
    }

    public static Resource getResource(String path) {
        return RESOURCE_LOADER.getResource(path);
    }

    public static String getPath(Resource resource) {
        Assert.notNull(resource);

        try {
            String pathToUse;
            if (resource instanceof ClassPathResource) {
                pathToUse = ((ClassPathResource) resource).getPath();
            } else if (resource instanceof FileSystemResource) {
                pathToUse = resource.getFile().getAbsolutePath();
            } else if (resource instanceof ZookeeperResource) {
                pathToUse = "zookeeper:" + ((ZookeeperResource) resource).getPath();
            } else {
                pathToUse = resource.getURL().getPath();
            }

            return pathToUse;
        } catch (IOException e) {
            return "";
        }
    }

    public static String getResourceProtocol(Resource resource) {
        Assert.notNull(resource);

        String protocol;
        if (resource instanceof ClassPathResource) {
            protocol = "classpath:";
        } else if (resource instanceof FileSystemResource) {
            protocol = "file:";
        } else if (resource instanceof ZookeeperResource) {
            protocol = "zookeeper:";
        } else {
            protocol = "";
        }

        return protocol;
    }

    public static String getContent(Resource resource, String fileEncoding) {
        Assert.notNull(resource);
        Assert.isTrue(resource.exists());

        try {
            return IOUtils.toString(resource.getInputStream(), StringUtils.isBlank(fileEncoding) ? "UTF-8" : fileEncoding);
        } catch (IOException e) {
            return "";
        }
    }

    public static String getContent(Resource resource) {
        return getContent(resource, "");
    }
}
