package homework.bread;

import org.w3c.dom.ls.LSOutput;

public class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public Animal() {
    }

    public void eat() {
        System.out.println("吃东西");
    }
    public void drink(){
        System.out.println("喝水");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
