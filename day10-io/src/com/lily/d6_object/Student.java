package com.lily.d6_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student implements Serializable {
    private String name;
    private int age;
    //用transient修饰的不同被序列化
    private transient String password;
    private double height;
}
