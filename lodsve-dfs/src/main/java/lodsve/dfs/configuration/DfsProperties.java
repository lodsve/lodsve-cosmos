package lodsve.dfs.configuration;

import org.csource.common.FastDfsConfig;
import lodsve.core.properties.autoconfigure.annotations.ConfigurationProperties;

/**
 * 配置.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version 1.0 2017-12-4-0004 10:46
 */
@ConfigurationProperties(prefix = "lodsve.dfs", locations = "${params.root}/framework/dfs_client.properties")
public class DfsProperties {
    private FastDfsConfig fastDfs;

    public FastDfsConfig getFastDfs() {
        return fastDfs;
    }

    public void setFastDfs(FastDfsConfig fastDfs) {
        this.fastDfs = fastDfs;
    }
}
