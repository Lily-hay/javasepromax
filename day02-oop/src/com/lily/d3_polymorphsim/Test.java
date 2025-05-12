package com.lily.d3_polymorphsim;

public class Test {
    interface  A{
        int x = 0;
    }
    public static class B{
        int x =1;
    }
    public static class C extends B implements A {
        public void pX(){
            System.out.println(A.x);//B.this.x
        }

    }
    public static void main(String[] args) {
        new C().pX();
    }
}
