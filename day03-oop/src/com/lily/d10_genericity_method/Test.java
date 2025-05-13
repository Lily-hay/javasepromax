package com.lily.d10_genericity_method;

public class Test {
    public static void main(String[] args) {
        String[] names={"欧阳","xiao","hsai"};
        printArray(names);

    }
    public static <T> T printArray(T[] t)
    {
        return t[0];
    }
}
