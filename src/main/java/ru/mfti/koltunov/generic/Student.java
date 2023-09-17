package ru.mfti.koltunov.generic;

import java.util.Arrays;

public class Student implements java.lang.Comparable<Student> {

    private String name;
    private Integer[] grade;

    public Student(String name) {
        this.name = name;
    }
    public Student(String name, Integer[] grade) {
        this(name);
        setGrade(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getGrade() {
        return grade.clone();
    }

    public void setGrade(Integer[] grade) {
        for (Integer integer : grade) {
            if (integer < 2 || integer > 5) {
                throw new IllegalArgumentException("Оценка не в диапазоне 2 - 5");
            }
            this.grade = grade.clone();
        }
    }

    @Override
    public String toString() {
        if (grade != null) {
            return "Студент: " + name + " Оценки: " + Arrays.toString(grade);
        }
        return "Студент: " + name + " Оценок нет";
    }

    public int average() {
        if (grade != null) {
            int result = 0;
            for (Integer integer : grade) {
                result += integer;
            }
            return result/grade.length;
        }
        return 0;
    }

    public boolean otl() {
        return average() == 5;
    }

    @Override
    public int compareTo(Student student) {
        return (this.average() - student.average());
    }
}



