package com.lily.d6_object;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("day10-io/src/com/lily/object.txt"));
        Student s=new Student("张三",27,"okk666",176.4);
        oos.writeObject(s);
    }
}
