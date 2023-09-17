package ru.mfti.koltunov.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomFactoryBeanProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        if (configurableListableBeanFactory.containsBeanDefinition("random")) {
            return;
        }
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) configurableListableBeanFactory;
        BeanDefinition randomFactoryBean = new GenericBeanDefinition();
        randomFactoryBean.setScope("singleton");
        randomFactoryBean.setBeanClassName("ru.mfti.koltunov.spring.RandomConfig");
        registry.registerBeanDefinition("randomFactory", randomFactoryBean);

        BeanDefinition randomBean = new GenericBeanDefinition();
        randomBean.setScope("prototype");
        randomBean.setFactoryBeanName("randomFactory");
        randomBean.setFactoryMethodName("rand");
        registry.registerBeanDefinition("random", randomBean);

    }
}

class RandomConfig {
    int rand() {
        return ThreadLocalRandom.current().nextInt(0, 99);
    }
}
