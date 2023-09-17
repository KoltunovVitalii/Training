package ru.mfti.koltunov;

import lombok.Builder;

public class ResetTestData {
    public static class SampleClass {
        private String name;
        private Integer age;

        public SampleClass() {
        }

        public SampleClass(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

    @Annotations.Default(SampleClass.class)
    public static class ClassWithDefaultAnnotation {
        @Builder.Default
        private String name;
        private Integer age;

        public ClassWithDefaultAnnotation() {
        }

        public ClassWithDefaultAnnotation(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
