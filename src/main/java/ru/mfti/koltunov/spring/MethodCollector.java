package ru.mfti.koltunov.spring;

public class MethodCollector {
    public MethodCollector(ru.mfti.koltunov.spring.MethodCollectionImpl methodCollection) {
    }

    private record MethodCollectionImpl() { }
    
    MethodCollectionImpl methodCollection;

    public MethodCollector(MethodCollectionImpl methodCollection) {
        this.methodCollection = methodCollection;
    }
}
