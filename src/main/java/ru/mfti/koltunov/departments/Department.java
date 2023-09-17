package ru.mfti.koltunov.departments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    String name;
    Employees head;
    List<Employees> employees = new ArrayList<>();

    public Department(String name) {
        setName(name);
    }

    public Department(String name, Employees head) {
        this(name);
        setHead(head);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employees getHead() {
        return head;
    }

    public List<Employees> getEmployees() {
        ArrayList<Employees> result = new ArrayList<>();
        Collections.copy(result, employees);
        return result;
    }

    public void addEmployees(Employees...employees) {
        for (Employees e: employees) {
            if (!this.employees.contains(e)) {
                this.employees.add(e);
            }
        }
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    void setHead(Employees head) {
        if (!employees.contains(head) && head.getDept() != this) {
            head.setDept(this);
        }
        this.head = head;
    }

    @Override
    public String toString() {
        return name;
    }
}
