package lodsve.test.mock.memcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.util.Assert;

/**
 * 内嵌式Memcached.
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version V1.0, 2018-1-10-0010 13:32
 */
public class JMemcachedTestExecutionListener extends AbstractTestExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger(JMemcachedTestExecutionListener.class);
    public static final String MEMCACHED_HOST = "127.0.0.1";

    private static boolean initialized;
    private JMemcachedServer server;

    public JMemcachedTestExecutionListener() {
        this.server = new JMemcachedServer();
    }

    @Override
    public void beforeTestClass(TestContext testContext) {
        startServer(testContext);
    }

    @Override
    public void afterTestMethod(TestContext testContext) {
        if (Boolean.TRUE.equals(testContext.getAttribute(DependencyInjectionTestExecutionListener.REINJECT_DEPENDENCIES_ATTRIBUTE))) {
            logger.debug("Cleaning and reloading server for test context [{}].", testContext);
            cleanServer();
            startServer(testContext);
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) {
        cleanServer();
    }

    private void startServer(TestContext testContext) {
        EmbeddedMemcached embeddedMemcached = AnnotationUtils.findAnnotation(testContext.getTestClass(), EmbeddedMemcached.class);

        Assert.notNull(embeddedMemcached, "EmbeddedMemcachedTestExecutionListener must be used with @EmbeddedMemcached on " + testContext.getTestClass());

        int port = embeddedMemcached.port();
        Assert.isTrue(port > 0, "@EmbeddedMemcached port must not be > 0");

        if (!initialized) {
            server.start(MEMCACHED_HOST, port);
            initialized = true;
        }
    }

    private void cleanServer() {
        server.clean();
    }
}
