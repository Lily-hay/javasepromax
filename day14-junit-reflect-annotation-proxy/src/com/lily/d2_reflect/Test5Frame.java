package com.lily.d2_reflect;

public class Test5Frame {
    public static void main(String[] args) throws Exception {
        Student s1=new Student("亦菲",28,"女","pretty");
        ObjectFrame.saveObject(s1);
    }
}
