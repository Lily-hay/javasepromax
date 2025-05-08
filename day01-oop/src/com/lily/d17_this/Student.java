package com.lily.d17_this;

public class Student {
    private String name;
    private int age;
    private String shoolName;
    public Student(){}
    public Student(String name, int age, String shoolName) {
        this.name = name;
        this.age = age;
        this.shoolName = shoolName;
    }

    public Student(String name, int age) {
        this(name,age,"xidian");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getShoolName() {
        return shoolName;
    }

    public void setShoolName(String shoolName) {
        this.shoolName = shoolName;
    }
}
