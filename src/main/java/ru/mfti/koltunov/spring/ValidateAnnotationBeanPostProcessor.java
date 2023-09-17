package ru.mfti.koltunov.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import ru.mfti.koltunov.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static ru.mfti.koltunov.LessonSeven.getValidateAnnotation;

public class ValidateAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    ApplicationContext context;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            validate(bean);
        } catch (Exception | ValidateExeption e) {
            throw new RuntimeException(e);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public void validate(Object... arr) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ValidateExeption {
        Validated validated;
        Class<?>[] testClassesNames;

        for (Object o : arr) {
            Class objectClass = o.getClass();

            validated = getValidateAnnotation(objectClass);

            if (validated != null) {
                testClassesNames = validated.value();
            } else if (objectClass.isAnnotationPresent(Validated.class)) {
                validated = (Validated) objectClass.getAnnotation(Validated.class);
                testClassesNames = validated.value();
            } else {
                continue;
            }
            for (Class<?> testClassName : testClassesNames) {
                Object bean = context.getBean(testClassName);
                Class testClass = bean.getClass();
                Method[] testClassMethods = testClass.getDeclaredMethods();
                Constructor<?> constructor = testClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object test = constructor.newInstance();

                for (Method m : testClassMethods) {
                    try {
                        m.invoke(test, o);
                    } catch (InvocationTargetException e) {
                        if (e.getCause().getClass() != ValidateExeption.class) {
                            throw e;
                        }
                        ValidateExeption validateExeption = (ValidateExeption) e.getCause();
                        StackTraceElement[] stack = validateExeption.getStackTrace();
                        StackTraceElement[] newStack = {stack[0]};
                        validateExeption.setStackTrace(newStack);
                        throw validateExeption;
                    }
                }
            }
        }
    }
    private Validated getValidateAnnotation(Class<?> objectClass) {
        Annotation[] annotations = objectClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Validated.class)) {
                return (Validated) annotation;
            }
        }
        return null;
    }
}
