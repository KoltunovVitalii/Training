package ru.mfti.koltunov.spring;

import lombok.Builder;
import org.springframework.context.ApplicationContext;
import ru.mfti.koltunov.Annotations;
import ru.mfti.koltunov.DefaultValues;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import static ru.mfti.koltunov.LessonSeven.collect;
import static ru.mfti.koltunov.LessonSeven.fieldCollection;

public class Reset {
    private static ApplicationContext context;
    private FieldCollectionable fieldCollectionable;
    private MethodCollector methodCollector;

    public Reset(ApplicationContext context, FieldCollectionable fieldCollectionable, MethodCollector methodCollector) {
        this.context = context;
        this.fieldCollectionable = fieldCollectionable;
        this.methodCollector = methodCollector;
    }

    public static void reset(Object... arr) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException {
        if (arr == null || arr.length == 0) {
            return;
        }

        Class cls;
        List<Field> fieldList;
        boolean isClassValueDefault;
        boolean isFiledValueDefault;
        Class annotationDefaultClass = null;
        Annotations.Default aDefault;

        for (Object o : arr) {
            cls = o.getClass();
            fieldList = fieldCollection(cls);
            isClassValueDefault = cls.isAnnotationPresent(Annotations.Default.class);

            for (Field field : fieldList) {
                if (isClassValueDefault) {
                    aDefault = (Annotations.Default) cls.getAnnotation(Annotations.Default.class);
                    annotationDefaultClass = aDefault.value();
                }
                isFiledValueDefault = field.isAnnotationPresent(Builder.Default.class);
                field.setAccessible(true);
                if (!isClassValueDefault) {
                    if (!isFiledValueDefault) {
                        continue;
                    }
                }
                if (isFiledValueDefault) {
                    aDefault = (Annotations.Default) cls.getAnnotation(Annotations.Default.class);
                    annotationDefaultClass = aDefault.value();
                    Object bean = context.getBean(annotationDefaultClass);
                    field.set(o, bean);
                    return;
                }

                if (annotationDefaultClass == null) {
                    continue;
                }
                Map<String, Object> map = collect(annotationDefaultClass);
                if (map.containsKey(field.getName())) {
                    field.set(o, map.get(field.getName()));
                } else {
                    field.set(o, DefaultValues.defaultValueFor(field.getClass()));
                }
            }
        }
    }

}
