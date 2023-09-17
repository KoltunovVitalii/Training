package ru.mfti.koltunov.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DefaultAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    ApplicationContext context;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Reset reset = new Reset(context, new FieldCollectionable(), new MethodCollector(new MethodCollectionImpl()));

        try {
            Reset.reset(bean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;
    }


}

