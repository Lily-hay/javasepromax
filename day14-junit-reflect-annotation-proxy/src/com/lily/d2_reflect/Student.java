package com.lily.d2_reflect;

public class Student {
    private String name;
    private int age;
    private String sex;
    private String desc;

    public Student() {}
    public Student(String name, int age, String sex, String desc) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.desc = desc;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
