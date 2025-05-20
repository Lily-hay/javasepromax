package com.lily.method_reference;

public class Test4 {
    public static void main(String[] args) {
        /*Create c1=new Create() {
            @Override
            public Car createCar(String name) {
                return new Car(name);
            }
        };*/
        //简化
        //Create c1=(String name)->new Car(name);
        //再简化
        Create c1=Car::new;

    }
}
interface Create{
    Car createCar(String name);
}
class Car{
    private String name;
    public Car(String name) {}

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}