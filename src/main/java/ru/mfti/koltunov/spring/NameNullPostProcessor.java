package ru.mfti.koltunov.spring;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class NameNullPostProcessor implements BeanPostProcessor {

    Map<String, Object> objs = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name") && field.getType().equals(String.class)) {
                field.setAccessible(true);
                objs.put(beanName, bean);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        if (!objs.containsKey(beanName)) {
            return bean;
        }
        Class<?> beanClass = objs.get(beanName).getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name") && field.getType().equals(String.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(bean) == null) {
                        field.set(bean, "vasia");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }
}





