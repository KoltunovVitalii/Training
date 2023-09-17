package ru.mfti.koltunov.departments;

class Employees {
    String name;
    Department dept;

    public Employees(String name, Department dept) {
        setName(name);
        setDept(dept);
        dept.getEmployees().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        if (this == this.dept.getHead() && this.dept != dept) {
            throw new IllegalArgumentException("аяяй я уже босс другого департамента");
        }
        this.dept = dept;
        this.dept.addEmployees(this);

    }

    @Override
    public String toString() {
        if (this != dept.getHead()) {
            return name + " работает в отделе " + dept + ", начальник которого " + dept.getName();
        } else return name + " начальник отдела " + dept.getName();
    }
}
