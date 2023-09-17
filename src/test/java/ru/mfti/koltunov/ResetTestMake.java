package ru.mfti.koltunov;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ResetTestMake {
    @Test
    public void testReset_NoAnnotations_DefaultValues() throws IllegalAccessException, NoSuchMethodException,
            InstantiationException, InvocationTargetException {
        ResetTestData.SampleClass sample = new ResetTestData.SampleClass("John Doe", 30);

        LessonSeven.reset(sample);

        // Verify that the fields are not modified
        assertEquals("John Doe", sample.getName());
        assertEquals(30, sample.getAge());
    }

    @Test
    public void testReset_ClassWithDefaultAnnotation_UseDefaultValues() throws IllegalAccessException,
            NoSuchMethodException, InstantiationException, InvocationTargetException {
        ResetTestData.ClassWithDefaultAnnotation instance = new ResetTestData.ClassWithDefaultAnnotation();
        instance.setName("Alice");
        instance.setAge(25);

        LessonSeven.reset(instance);

        // Verify that the fields are reset to default values
        assertNull(instance.getName());
        assertEquals(0, instance.getAge());
    }

    @Test
    public void testReset_ClassWithDefaultAnnotation_NoDefaultValues() throws IllegalAccessException,
            NoSuchMethodException, InstantiationException, InvocationTargetException {
        ResetTestData.ClassWithDefaultAnnotation instance = new ResetTestData.ClassWithDefaultAnnotation("Bob", 40);

        LessonSeven.reset(instance);

        // Verify that the fields are not modified
        assertEquals("Bob", instance.getName());
        assertEquals(40, instance.getAge());
    }

    @Test
    public void testReset_MultipleObjects() throws IllegalAccessException, NoSuchMethodException,
            InstantiationException, InvocationTargetException {
        ResetTestData.SampleClass sample = new ResetTestData.SampleClass("John Doe", 30);
        ResetTestData.ClassWithDefaultAnnotation instance = new ResetTestData.ClassWithDefaultAnnotation("Bob", 40);

        LessonSeven.reset(sample, instance);

        // Verify that the fields are reset for each object
        assertEquals("John Doe", sample.getName());
        assertEquals(30, sample.getAge());

        assertNull(instance.getName());
        assertEquals(40, instance.getAge());
    }
}


