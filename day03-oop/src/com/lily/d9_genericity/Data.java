package com.lily.d9_genericity;

public interface Data<T> {
     void add(T t);
     void remove(T t);
     void modify(T t);
     void getById(int id);
}
