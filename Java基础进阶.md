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

### 2、继承

关键词extends

```
public class B extends A {}
```

特点：子类中能继承父类的非私有成员，带继承的类，其对象由子类和父类共同创建完成

```
B b=new B();//子类对象创建的特点：会由子类·和父类多张设计图共同创建，但能访问什么还是要看权限，后续可用get,set方法访问私有成员
//System.out.println(b.k);报错
System.out.println(b.i);
//System.out.println(b.j);报错
b.print1();
```

继承的好处

减少重复代码的编写，提高代码的复用性

将共同的特性继承到子类中

#### 权限修饰符

（限制类中成员（成员变量、成员方法、构造器、代码块）能够被访问的范围）

private  只能在本类

缺省     本类、同一个包中的类

protected 本类、同一个包的类、子孙类（跨包时）

public   任意位置

#### 单继承

Java是单继承的，一个类只能继承一个直接父类，不支持多继承，支持多层继承

Object类是Java所有类的祖宗类

#### 方法重写

当子类觉得父类中的方法不好用时，或者没办法满足自己的需求，子类可以重写一个方法名称、参数列表类相同的方法去覆盖父类中的方法

重写后，Java会通过就近原则

1、注意事项：

使用@override注解，会检查格式是否正确

子类重写父类时，访问权限范围大于或等于父类方法的权限

重写的方法返回值类型，必须与父类相同或者范围更小

静态方法、私有方法重写会报错

2、方法重写的应用场景

object的toString是显示地址，可以改写

3、继承后，子类访问成员的特点：就近原则，子类没有找父类，父类没有报错

当子类父类中有重名成员时，在子类中调用时，会优先访问子类中的，若要访问父类中的，加super.

4、子类构造器的特点

继承后，子类的构造器会先调用父类的构造器，再执行自己的

```
public class Wolf extends Animal {
    public Wolf(){
        //super();//写不写都有，调用父类的无参构造器
        System.out.println("子类的无参构造器执行了");
    }
    public Wolf(String n)
    {
        //super(n);//写不写都有，调用父类的有参构造器
        System.out.println("子类的无参构造器执行了");
    }
}
```

子类调用父类的构造器，初始化继承源自父类部分的数据

```
public Teacher(String name, int age, String skills) {
    super(name, age);//子类调用父类的构造器，初始化继承源自父类部分的数据
    this.skills = skills;
}
```

在对象中，可直接通过构造器为子类和父类数据赋值

5、this(...)调用兄弟构造器的作用

通过调用兄弟构造器，可重新默认部分参数

this(...)，super(...)不能同时出现，且都要在构造器的第一行使用

```
public Student(String name, int age, String shoolName) {
    this.name = name;
    this.age = age;
    this.shoolName = shoolName;
}

public Student(String name, int age) {
    this(name,age,"xidian");//调用兄弟构造器，可重新默认部分参数
}
```