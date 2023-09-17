package ru.mfti.koltunov.figures;

import java.util.ArrayList;
import java.util.List;

public class MultiPoint {
    List<Attribute> attributeList = new ArrayList<>() {
    };
}

class Attribute {
    String name;
    Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;


    }
}

