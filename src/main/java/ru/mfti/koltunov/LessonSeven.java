package ru.mfti.koltunov;

import lombok.Builder;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import ru.mfti.koltunov.figures.Point2D;
import ru.mfti.koltunov.generic.Line;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class LessonSeven {

    public static List<Field> fieldCollection(Object o) {
        Class<?> cl = o.getClass();
        List<Field> lstr = new ArrayList<>();
        while (cl != Object.class) {
            lstr.addAll(Arrays.asList(cl.getDeclaredFields()));
            cl = cl.getSuperclass();
        }
        return lstr;
    }

    public static void lineConnector(Line<Point2D> line1, Line<Point2D> line2) throws NoSuchFieldException,
            IllegalAccessException {
        Field start = line2.getClass().getDeclaredField("start");
        Field end = line1.getClass().getDeclaredField("end");
        start.setAccessible(true);
        end.setAccessible(true);
        start.set(line1, end.get(line2));
    }

    public static void validate(Object o, Class cls) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Method[] methods = cls.getMethods();
        Constructor<?> constructor = cls.getConstructor();
        Object object = constructor.newInstance();

        for (Method m : methods) {
            m.invoke(object, o);
        }
    }

    public static void validate(Object... arr) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Annotations.Validate validate;
        Class[] classes;
        for (Object o : arr) {
            Class objectClass = o.getClass();
            validate = getValidateAnnotation(objectClass);
            if (validate != null) {
                classes = validate.value();
            } else if (objectClass.isAnnotationPresent(Annotations.Validate.class)) {
                validate = (Annotations.Validate) objectClass.getAnnotation(Annotations.Validate.class);
                classes = validate.value();
            } else {
                continue;
            }
            validate = null;
            for (Class cls : classes) {
                Method[] clsMetods = cls.getDeclaredMethods();
                Constructor<?> constructor = cls.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object objectTest = constructor.newInstance();

                for (Method m : clsMetods) {
                    m.invoke(objectTest, o);
                }
            }
        }
    }

    public static Annotations.Validate getValidateAnnotation(Class objectClass) {
        Annotations.Validate validate = null;
        Annotation[] annotations = objectClass.getAnnotations();
        for (Annotation a : annotations) {
            Class annotationClass = a.getClass();
            if (annotationClass.isAnnotationPresent(Annotations.Validate.class)) {
                validate = (Annotations.Validate) annotationClass.getDeclaredAnnotation(Annotations.Validate.class);
                break;
            }
        }
        return validate;
    }

    public static Map<String, Object> collect(Class... arr) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Object> result = new HashMap<>();
        List<Method> methodList;

        for (Class cls : arr) {
            methodList = methodsCollection(cls);
            Constructor constructor = cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object objMake = constructor.newInstance();
            for (Method method : methodList) {
                //чистим от НЕ инвоков
                if (!method.isAnnotationPresent(Annotations.Invoke.class)) {
                    continue;
                }
                //чистим от методов с параметрами
                if (method.getParameterCount() > 0) {
                    continue;
                }
                //чистим от войтовских методов
                if (method.getReturnType().equals(Void.TYPE)) {
                    continue;
                }

                method.setAccessible(true);
                result.put(method.getName(), method.invoke(objMake));
            }
        }
        return result;
    }

    public static List<Method> methodsCollection(Class cls) {
        List<Method> lst = new ArrayList<>();
        while (cls != Object.class) {
            lst.addAll(Arrays.asList(cls.getDeclaredMethods()));
            cls = cls.getSuperclass();
        }
        return lst;
    }

    public static void reset(Object... arr) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException {
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

    public static List<Field> fieldCollection(Class cls) {
        List<Field> fieldList = new ArrayList<>();
        while (cls != Object.class) {
            fieldList.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return fieldList;
    }
}


abstract class Entity {
    @Override
    public String toString() {
        Class<?> cls = getClass();
        List<Field> fieldList = LessonSeven.fieldCollection(this.getClass());
        Map<String, Object> fieldMap = new HashMap<>();

        try {
            for (Field f : fieldList) {
                ToString toStringField = f.getAnnotation(ToString.class);
                ToString toStringClass = f.getDeclaringClass().getAnnotation(ToString.class);
                if (toStringField.equals(Annotations.NeedToString.NO) || toStringClass.equals(Annotations.NeedToString.NO)) {
                    continue;
                }
                f.setAccessible(true);
                fieldMap.put(f.getName(), f.get(this));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this.getClass().getSimpleName() + fieldMap;
    }
}


