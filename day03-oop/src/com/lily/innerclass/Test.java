package com.lily.innerclass;

public class Test {
    public static void main(String[] args) {
        People.Heart h=new People().new Heart();
        h.show();
    }
}
