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

package lodsve.core.properties;

import lodsve.core.properties.message.DefaultResourceBundleMessageSource;
import lodsve.core.utils.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;


/**
 * 国际化资源文件工具类
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2012-3-14 下午07:59:37
 */
@Component
public class Messages implements ApplicationContextAware {
    /**
     * 国际化资源文件处理类在spring上下文中的key
     */
    private static final String DEFAULT_MESSAGE_SOURCE = "messageSource";

    private static DefaultResourceBundleMessageSource bundleMessageSource = null;
    private static final Object LOCK_OBJECT = new Object();
    private static Map<Locale, Map<String, String>> allMessagesMap = new HashMap<>();
    private static ApplicationContext context;

    @PostConstruct
    public void init() {
        synchronized (LOCK_OBJECT) {
            Object obj = context.getBean(DEFAULT_MESSAGE_SOURCE);

            if (obj instanceof DefaultResourceBundleMessageSource) {
                bundleMessageSource = (DefaultResourceBundleMessageSource) obj;
            } else if (obj instanceof DelegatingMessageSource) {
                DelegatingMessageSource delegatingMessageSource = (DelegatingMessageSource) obj;
                Object obj2 = delegatingMessageSource.getParentMessageSource();
                if (obj2 instanceof DefaultResourceBundleMessageSource) {
                    bundleMessageSource = (DefaultResourceBundleMessageSource) obj2;
                } else {
                    throw new RuntimeException("can not find any messageSource what is DefaultResourceBundleMessageSource!");
                }
            }
        }
    }

    /**
     * get message by locale, and format with args
     *
     * @param code           键
     * @param locale         语言
     * @param defaultMessage String to return if the lookup fails
     * @param args           参数
     * @return
     */
    public static String getMessage(String code, Locale locale, String defaultMessage, String... args) {
        return context.getMessage(code, args, defaultMessage, locale);
    }

    /**
     * get message by locale, and format with args
     *
     * @param code   键
     * @param locale 语言
     * @param args   参数
     * @return
     */
    public static String getMessage(String code, Locale locale, String... args) {
        return context.getMessage(code, args, StringUtils.EMPTY, locale);
    }

    /**
     * get message by locale, and format with args
     *
     * @param code 键
     * @param args 参数
     * @return
     */
    public static String getMessage(String code, String... args) {
        return context.getMessage(code, args, StringUtils.EMPTY, Locale.getDefault());
    }

    /**
     * get message by locale, and format with args
     *
     * @param code 键
     * @return
     */
    public static String getMessage(String code) {
        return context.getMessage(code, new Object[0], StringUtils.EMPTY, Locale.getDefault());
    }

    /**
     * 获取locale语言下所有的message
     *
     * @param locale
     * @return
     */
    public static Map<String, String> getMessages(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }

        Map<String, String> allMessages = allMessagesMap.get(locale);
        if (allMessages != null) {
            return allMessages;
        }

        ResourceBundle bundle = bundleMessageSource.getResourceBundle(locale);
        Enumeration<String> keys = bundle.getKeys();

        Map<String, String> messages = new HashMap<>(16);
        for (; keys.hasMoreElements(); ) {
            String key = keys.nextElement();
            String message = bundle.getString(key);

            messages.put(key, message);
        }

        allMessagesMap.put(locale, messages);

        return messages;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
