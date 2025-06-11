package com.lily.d6_object;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("day10-io/src/com/lily/object.txt"));
        Student s=(Student)ois.readObject();
        System.out.println(s);
    }
}
