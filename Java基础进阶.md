# Java基础进阶

## 1、面向对象

### 1、static

#### static修饰成员变量

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

```
访问当前类中的静态变量，可以省略类名不写
```

#### static修饰成员方法

类方法（静态方法）：属于类，常见的应用场景是做工具类

实例方法（对方方法）：属于对象

```
Student s1 = new Student();
Student.printHelloWorld();//静态方法，通过类名直接访问
s1.printHelloWorld();//也可用对象访问，不推荐
Student s2 = new Student();
s2.score=70;
s2.pass();//实例方法，只可通过对象访问
```

应用场景

静态方法做工具类，调用方便，节约内存，不用创建对象访问，最好将构建对象私有

注意事项

```
1、静态方法中，可以直接访问类的静态成员，不能直接访问实例成员，因为调用静态方法时，直接调用，而实例成员又需要通过对象来使用
```

```
2、实例方法中，可以直接访问静态成员，也可以直接访问实例成员
```

```
3、静态方法中，不可出现this,实例方法可以，本质是，this也要通过对象来进行访问
```

#### 代码块

类中五个部分(成员变量，成员方法，代码块，构造器，)

静态代码块static{}

特点：类加载时自动执行，Y由于类只加载一次，静态代码块也是

作用：完成类的初始化（对类的初始化赋值）

实例代码块

{}

每次创建对象时，执行实例代码块，并在构造器之前执行

#### 单例设计模式

设计模式就是具体问题的最优解决方案

确保一个类只有一个对象

```
//2、创建一个静态变量用于记住类的一个唯一对象
    private static A a = new A();
//    1、把构造器私有化处理
    private A(){

    }
    //3、提供一个返回这个唯一对象的静态方法
    public static A getInstance(){
        return a;
    }
```

单例模式的应用场景和好处

任务管理器对象、获取运行时对象

1、懒汉式单例设计模式

要用类的对象时才创建对象

```
public class B {
    private static B b;
    private B(){

    }
    public static B getInstance(){
        //判断是否时第一次创建对象
        if(b==null){
            b=new B();
        }
        return b;
    }
}
```