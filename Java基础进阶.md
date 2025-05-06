# Java基础进阶

## 1、面向对象

### 1、static



类变量（静态变量）：有static修饰，属于类，**计算机里只有一份**，会被其他类的全部对象共享，直接用类访问，不推荐用对象访问

实例变量（对象变量）：无static修饰，属于每个对象的，**只能用对象使用**

```
//静态变量可用类直接访问
Student.name="小明";
System.out.println(Student.name);
//不推荐用对象访问
Student s1=new Student();
s1.name="小红";
System.out.println(s1.name);
Student s2=new Student();
s2.name="小张";
System.out.println(s1.name);//由于地址只有一份，结果为小张

//实例变由对象访问，修改值各不影响
s1.age=18;
s2.age=24;
System.out.println(s1.age);//结果为18
```