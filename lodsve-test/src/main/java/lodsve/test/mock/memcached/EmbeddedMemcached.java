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
