package ru.mfti.koltunov;

import lombok.Builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Annotations.Default(value = Clazz.class)
class Clazz{

    final int x = 2;

    @Annotations.Invoke
    public static void main(String[] args) {

    }
}

public class Annotations {
    //7.2.1.
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Invoke{}


    //7.2.2.
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface Default{Class value();}
    //7.2.3.

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface toString {
        NeedToString value() default NeedToString.YES;
    }
    enum NeedToString{
        YES, NO
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @interface Validate{
        Class[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Two {
        String first();
        int second();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Cashe {
        String[] value() default {};
    }

}
