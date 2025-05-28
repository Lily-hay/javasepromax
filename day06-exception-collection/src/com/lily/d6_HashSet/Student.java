package com.lily.d6_HashSet;

import java.util.Objects;

public class Student {
    private String name;
    private String sex;
    private String hubby;

    public Student(String name, String sex, String hubby) {
        this.name = name;
        this.sex = sex;
        this.hubby = hubby;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(sex, student.sex) && Objects.equals(hubby, student.hubby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, hubby);
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHubby() {
        return hubby;
    }

    public void setHubby(String hubby) {
        this.hubby = hubby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", hubby='" + hubby + '\'' +
                '}';
    }
}
