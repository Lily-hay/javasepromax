package com.lily.d3_method_reference;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private String sex;
    private double height;

    public Student() {

    }

    public Student(String name, int age, String sex, double height) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
    }
    public static int compareByHeight(Student s1, Student s2) {
        return Double.compare(s1.getHeight(), s2.getHeight());
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    //o:被比较者
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();//升序
    }

}

