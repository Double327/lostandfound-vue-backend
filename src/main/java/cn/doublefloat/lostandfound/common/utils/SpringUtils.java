package cn.doublefloat.lostandfound.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @author 李广帅
 * @date 2020/7/3 4:38 下午
 */
@Component
public final class SpringUtils implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory;

    public static <T> T getBean(String name) {
        return (T) beanFactory.getBean(name);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        SpringUtils.beanFactory = configurableListableBeanFactory;
    }

    public static <T> T getBean(Class<T> clz) {
        return beanFactory.getBean(clz);
    }
}
