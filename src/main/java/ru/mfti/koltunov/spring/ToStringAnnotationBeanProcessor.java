package ru.mfti.koltunov.spring;

import com.sun.jdi.Field;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class ToStringAnnotationBeanProcessor implements BeanPostProcessor {
//
//    private final FieldCollectionable fieldCollectionable = new FieldCollectionable();
//
//    private final Map<String, Object> map = new HashMap<>();
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        map.put(beanName, bean);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        Object originalBean = map.get(beanName);
//        Class cls = originalBean.getClass();
//        boolean isAnnotationToString = false;
//
//        List<Field> methodList = fieldCollectionable.fildCollection(cls);
//
//        for (Field field : methodList) {
//            if (field.isAnnotationPresent(ToString.class)) {
//                isAnnotationToString = true;
//                break;
//            }
//        }
//
//        if (cls.isAnnotationPresent(ToString.class) || isAnnotationToString) {
//            ClassLoader classLoader = originalBean.getClass().getClassLoader();
//            Class<?>[] interfaces = originalBean.getClass().getInterfaces();
//            ToStringInvocationHandler invocationHandler = new ToStringInvocationHandler(originalBean);
//            return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
//
//        }
//        return BeanPostProcessor.super.postProcessAfterInitialization(originalBean, beanName);
//    }
//
//    class ToStringInvocationHandler implements InvocationHandler {
//
//        private final Object objectOriginal;
//
//        public ToStringInvocationHandler(Object objectOriginal) {
//            this.objectOriginal = objectOriginal;
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            if (method.getName().equals("ToString")) {
//                return toStringHandlingMethod(objectOriginal);
//            } else {
//                return method.invoke(objectOriginal, args);
//            }
//        }
//
//        private String toStringHandlingMethod(Object o) {
//            Class cls = o.getClass();
//            List<Field> fields = fieldCollectionable.fildCollection(cls);
//
//            Map<String, Object> fieldMap = new HashMap<>();
//            for (Field f : fields) {
//                ToString toStringField = f.getAnnotation(ToString.class);
//                ToString toStringClass = f.getDeclaringClass().getAnnotation(ToString.class);
//
//                NeedToString review = NeedToString.NO;
//
//                if (toStringClass != null) {
//                    review = toStringClass.value();
//                }
//                if (toStringField != null) {
//                    review = toStringField.value();
//                }
//                if (review == NeedToString.NO) {
//                    continue;
//                }
//                f.setAccessible(true);
//            }
//            return o.getClass().getSimpleName() + fieldMap;
//        }
//    }
//}
