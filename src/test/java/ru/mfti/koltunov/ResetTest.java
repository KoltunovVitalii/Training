package ru.mfti.koltunov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class ResetTest {
    public static class MyClass {
        @Annotations.Default(ValueHolder.class)
        private final ValueHolder valueHolder;

        private int intValue;

        private String stringValue;

        public MyClass() {
            this.valueHolder = null;
            this.intValue = 0;
            this.stringValue = "";
        }

        public ValueHolder getValueHolder() {
            return valueHolder;
        }

        public int getIntValue() {
            return intValue;
        }

        public String getStringValue() {
            return stringValue;
        }
    }

    public static class ValueHolder {
        @Builder.Default
        private final int defaultValue = 42;

        public int getDefaultValue() {
            return defaultValue;
        }
    }

    public static class Annotations {
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Default {
            Class<?> value();
        }
    }

    public static class Builder {
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Default {
        }
    }

    public Map<String, Object> collect(Class<?> cls) {
        Map<String, Object> map = new HashMap<>();
        try {
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(null));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }



    @Test
    public void testReset() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException {
        MyClass myClass = new MyClass();
        myClass.intValue = 10;
        myClass.stringValue = "Hello";

        LessonSeven.reset(myClass);

        Assertions.assertNull(myClass.getValueHolder());
        Assertions.assertEquals(10, myClass.getIntValue());
        Assertions.assertEquals("Hello", myClass.getStringValue());
    }


}