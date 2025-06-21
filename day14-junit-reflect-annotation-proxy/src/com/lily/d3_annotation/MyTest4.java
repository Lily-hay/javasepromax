package com.lily.d3_annotation;

public @interface MyTest4 {
    String value();
    double aaa() default 100;
    String[] bbb();
}
