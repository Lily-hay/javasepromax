package com.lily.d16_extends_constuctor2;

public class Teacher extends People{
    String skills;
    public Teacher(){}
    public Teacher(String name, int age, String skills) {
        super(name, age);//子类调用父类的构造器，初始化继承源自父类部分的数据
        this.skills = skills;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }

}
