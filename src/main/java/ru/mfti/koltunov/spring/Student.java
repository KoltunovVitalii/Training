package ru.mfti.koltunov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

public class Student {
    private String name;
    private Predicate<Integer> range;
    private int[] grades;

    private Student(String name, Predicate<Integer> range, int[] grades) {
        this.name = name;
        this.range = range;
        this.grades = grades;
    }
    @Component("StudCreator")
    public static class StudentFactory{
        @Autowired
        Predicate<Integer> range;
        public Student getStudent(String name, int... estimates) {
            return new Student(name, range, estimates);
        }
    }
}
