package com.lily.static_field;

public class User {
   static int number;
   public User()
   {
       //User.number++;
       number++;//访问当前类中的静态变量，可以省略类名不写
   }
}
