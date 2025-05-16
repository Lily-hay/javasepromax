# Java基础进阶

## 1、面向对象进阶

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

### 3、多态

多态是在继承/实现情况下的一种现象，表现为：对象多态、行为多态

多态的前提:有**继承/实现**关系；存在父类引用子类对象；**存在方法重写**

```
Animal a1=new Cat();//编译看左，运行看右
a1.cry();
Animal a2=new Dog();//编译看左，运行看右
a2.cry();
System.out.println(a1.name);//成员变量没有多态
System.out.println(a2.name);
```

1、使用多态的好处

右边的对象是解耦合的，更便于扩展和维护，定义方法时，使用父类类型的形参，可以接受一切子类对象，扩展性更强，更便利。

多态下的问题：不能直接调用子类独有的行为

```
public static void main(String[] args) {
    Animal a=new Cat();//右边的对象是解耦合的，更便于扩展和维护
    a.cry();
    Cat c=new Cat();
    Dog d=new Dog();
    go(c);
    go(d);

}
public static void go(Animal a)//定义方法时，使用父类类型的形参，可以接受一切子类对象，扩展性更强，更便利
{
    System.out.println("----开始------");
    a.cry();
    //a.catchFish//多态下的问题：不能直接调用子类独有的行为
    System.out.println("-------结束--------");
}
```

多态下的类型转换：

自动类型转换、强制类型转换

强制类型需要注意：

存在继承、实现关系时，就可以强转，编译阶段不报错，但运行时，如果发现对象的真实类型与强转后的类型不符，会报错（ClassCastException），用instanceof判断类型

```
if(a instanceof Dog)
{
    Dog d=(Dog) a;
    d.lookdoor();
}
else
{
    Cat c=(Cat) a;
    c.catchFish();
}
```

### 4、final关键字

可以修饰（类、方法、变量）

修饰类：最终类，该类不可以被继承

修饰方法：最终方法，该方法不可以被重写

修饰变量：该变量只能被赋值一次

修饰**基本类型**的变量，则变量存储的**数据**不能被改变

修饰**引用类型**的变量，则变量存储的**地址**不能被改变，但地址所指向的对象中的内容可以被改变。

static final共同修饰的叫**常量**，只能在开始或代码块进行赋值

```
public static final String SCHOOL_NAME="黑马";//常量
    public static final String SCHOOL_NAME2;//常量
    static{
        SCHOOL_NAME2="黑马程序员";
    }
```

常量的作用：记录系统的配置信息

代码可读性好，方便维护

### 5、抽象类

关键字：abstract,在类或方法前加入，**抽象方法只有方法签名，不能写方法体**

1、抽象类中不一定有抽象方法，但有抽象方法的类必须是抽象类

2、类中有的成员（成员方法、变量、构造器），抽象类中也具备

3、**抽象类不能创建对象**，仅作为一种特殊的父类，让子类继承并实现

4、**一个类继承抽象类，必须全部重写抽象类的全部抽象方法**，否则该类也必须定义为抽象类

抽象类的场景：为了更好的支持多态，父类知道每个子类做某个行为，但每个子类的情况不一样

好处：方法体无意义可以不写（简化代码），强制子类重写（更好地支持多态）

模板方法设计模式：解决方法中存在重复代码的问题

某方法整体步骤相同，方法中有一些内容是每个类相同的，部分不同，在抽象类中将共同的部分写出，此方法即为模板方法，不同的部分重新定义一个抽象方法，由模板方法引用，由子类重新编写

模板方法加final，不让重写，final与abstract互斥

### 6、接口

关键字:interface

jdk8之前

public interface Name{

常量

抽象方法

}

可省略abstract不写

**接口的特点：不能创建对象**；接口是用来被类**实现**的，实现接口的类称为**实现类**

修饰符 class 实现类 implement 接口1，接口2，...{

}

*实现类，必须全部重写接口的全部抽象方法**，否则该类也必须定义为抽象类

接口的好处：

1、弥补了类单继承的不足，一个类可以实现多个接口

2、让程序面向接口编程，可以方便灵活的切换各种业务实现（灵活实现解耦合）

接口的继承：一个接口可以同时继承多个接口，可以让实现类只实现一个接口

jdk8开始接口新增三种方法

增强了接口的能力，更便于项目的拓展和维护

```
//1、默认方法,用default修饰
//默认用public修饰
//必须用接口实现类调用
default void run()
{
    go();
    System.out.println("跑得很快");
}

//2、私有方法（jdk9开始才有）
//只能由当前接口里的默认方法或私有方法调用
private void go()
{
    System.out.println("开始跑");
}

//3、静态方法
//默认用public修饰
//接口的静态方法由接口本身调用
static void inAddr()
{
    System.out.println("我爱学Java");
}
```

接口的注意事项：

1、一个接口继承多个接口，如果多个接口中存在方法签名冲突，此时不支持多继承

2、一个类实现多个接口，如果多个接口中存在方法签名冲突，此时不支持多实现

3、一个类同时继承父类，实现一个接口，若是，父类和接口中存在方法签名冲突，优先使用父类的方法

4、一个类实现多个接口，多个接口中存在默认方法，可以不冲突，这个类重写该方法即可

### 7、内部类

类中的类

当一个类的内部，包含了一个完整的事物，且没有必要单独设计时

#### 1、成员内部类

特点：无static修饰，属于外部类对象持有，必须有外部类对象，才会有这个成员内部类

成员内部类中，可以直接访问外部类的静态成员，也可以直接访问实例成员

当内部类与外部类有重名时，可以通过 **外部类.this.** 访问外部类成员

创建对象时 **外部类.内部类 对象名称=new 外部类().new 内部类()**

```
People.Heart h=new People().new Heart();
h.show();
```

```
public class People {
    private int heartBeat=110;
    public class Heart
    {
        private int heartBeat=95;
        public void show() {
            int heartBeat = 80;
            System.out.println(heartBeat);//80
            System.out.println(this.heartBeat);//95
            System.out.println(People.this.heartBeat);//110
        }
    }

}
```



2、静态内部类

有static修饰

创建对象时 **外部类.内部类 对象名称=new 外部类.内部类()**

不可以直接访问外部类实例成员（没有创建外部类）

3、局部内部类

定义在方法中、代码块、构造器中等局部的类

#### 4、**匿名内部类**

一种特殊局部内部类，匿名，即指程序员不需要为这个类声明

new 类或接口（参数值）

{

类体（一般是方法重写）

}

特点：**匿名内部类本质时一个子类，同时会立即创建一个子类对象**

匿名内部类的名称，当前类名&编号

作用：更方便地创建一个子类对象

```
public class Test {
    public static void main(String[] args) {
        Animal a=new Animal()//匿名内部类
        {
            @Override
            public void cry() {
                System.out.println("狗汪汪叫---");
            }
        };
        a.cry();
    }
}
abstract class Animal
{
    public abstract void cry();
}
```

匿名内部类的使用场景

**通常作为一个参数传递给方法**

```
public class Test2 {
    public static void main(String[] args) {
        //匿名内部类的使用场景
        //方法1
        Swimming s=new Swimming() {
            @Override
            public void swim() {
                System.out.println("老师游得慢-----");
            }
        };
        go(s);
        //方法二
        go(new Swimming() {
            @Override
            public void swim() {
                System.out.println("学生游得快·········");
            }
        });

    }

    public static void go(Swimming s)
    {
        System.out.println("开始-------");
        s.swim();
        System.out.println("结束------");
    }
}
interface Swimming
{
    public void swim();
}
```

能简化代码

### 8、枚举

一种特殊的类

1、**枚举类的第一行只能罗列一些名称**，这些名称都是**常量**，并且每个常量记住的是枚举类的一个对象

2、构造器私有，枚举类，不能对外构建对象

3、枚举属于最终类，不能被继承

4、枚举类中，从第二行开始，可以定义其他成员

5、编译器为枚举类新增了几个方法，并且枚举类都是继承：java.lang.Enum类的，得到一些方法values()  valueof()

枚举的场景：

**通常用来表示一组信息，然后作为参数进行传输**

常量做信息分类也比较优雅，但缺乏约束；枚举做信息标志和分类，参数值受到约束，最好的信息标志和分类的理想方案

### 9、泛型

定义类、接口、方法时，同时声明了一个或多个类型变量（<E>），称为泛型类、泛型接口、泛型方法，统称泛型

如ArrayList<E>

作用：在编译阶段约束所能操作的数据类型，并进行自动检查，**可以避免强制类型转换以及可能出现的异常**

泛型的本质：把具体类型作为参数传给类型变量

泛型变量一般用大写字母E、T、K、V

通配符： ？使用泛型时代表一切类型

泛型的上下限： ? extends  父类

​			    ？super    

泛型的擦除问题和注意问题：泛型是工作在编译阶段的，一旦程序编译为class文件，class文件中就不存在泛型；泛型不能直接支持基本数据类型，只能支持对象类型（引用）

### 10、API

Java已经写好的程序

object类是Java所有类的祖宗类

object    toString，equals（默认比较两个类的地址）给子类重写

objects 工具类 提供的equals 比较两个对象是否相同，比起改写的object.equals,更安全，更可靠，推荐使用

包装类

将基本数据类型包装成对象

int          Integer

byte       Byte

short     Short

long      Long

char	Character

float	Float

double	Double

boolean	Boolean

自动装箱机制

自动拆箱机制

```
//认识包装类
int a=12;
//1、把基本类型包装为对象
Integer it1=Integer.valueOf(a);//手动包装
System.out.println(it1);

//2、自动装箱机制，基本类型的对象可以直接变成对象
Integer it2=127;
Integer it3=127;
System.out.println(it2==it3);//true  -128到127提供了缓存，调用的是同一个对象,超过这个范围创建的是新对象
Integer it4=128;
Integer it5=128;
System.out.println(it4==it5);//false

//3、自动拆箱机制，包装类的对象可以直接给到基本类型
Integer it6=15;
int b=it6;

//Java为包装类提供了新功能
//1、包装类可以把基本类型的数据转为字符串
Integer it7=18;
String rs=it7.toString();
System.out.println(rs+2);
//2、把字符串数据转换为对应的基本数据类型
String re2="18.8";
Double s=Double.parseDouble(re2);
System.out.println(re2);
Double d=Double.valueOf(re2);
```

## 2、API

### 1、StringBuilder

可代表字符串对象，**相当于一个容器**，里面装的字符串可以改变，**就是用来操作字符串的**

好处:比String**更适合做字符串的修改操作，效率会更高，代码更简洁**

```
//1、创建对象
StringBuilder s1 = new StringBuilder("黑马");
System.out.println(s1);

//2、拼接内容
s1.append("java").append(666).append("ture");
System.out.println(s1);

//3、反转内容
s1.reverse();
System.out.println(s1);

//4、长度
s1.length();

//5、将StringBuilder对象转换为String对象
//StringBuilder是拼接字符串的手段，String是开放中的目的，开放中多数要String对象来接
String s2=s1.toString();
System.out.println(s2);
```

在需要多次拼接时，StringBuilder效率更高String用+=拼接时，会创建多个对象

StringBuilder与StringBuffer用法相同，但StringBuilder线程不安全，StringBuffer安全

### 2、StringJoiner

操作字符串，也可看作是一个容器，，内容可变

好处：不仅能提高字符串都操作效率，并且**在有些场景下使用它操作字符串，代码会更简洁**

```
public static String getArrayData(int[] arr)
    {
        
        StringJoiner s1 = new StringJoiner(",","[","]");//参数分别为中间的拼接符、开始、结束
        for (int i = 0; i < arr.length; i++) {

            s1.add(Integer.toString(arr[i]));
        }
        return s1.toString();
    }
}
```

### 3、Math、Runtime、System

Runtime可以获知虚拟机的内存以及电脑可用的

System.currnetTime.Mills时间毫秒值

### 4、BigDecimal

处理浮点数的对象

public BihDecimal(double val)//只能处理大数据问题，不能处理精度问题，不推荐使用

public BihDecimal(String val)//可以处理精度问题

```
double a=0.1;
double b=0.2;
//直接计算
double c=a+b;
System.out.println(c);//0.30000000000000004精度失真

//1、创建对象
BigDecimal a1=new BigDecimal(Double.toString(a));
BigDecimal b1=new BigDecimal(Double.toString(b));

//2、用BigDecimal作为手段计算
BigDecimal c1=a1.add(b1);

//3、返回double
double c11=c1.doubleValue();
System.out.println(c11);
```

5、ZoneId,ZoneDateTime

时区和时区时间

```
Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();//所有时区
System.out.println(availableZoneIds);

ZoneId an=ZoneId.of("America/Cuiaba");
ZonedDateTime dt=ZonedDateTime.now(an);//拿到时间

System.out.println(dt);

ZonedDateTime st=ZonedDateTime.now(Clock.systemDefaultZone());//拿到世界标准时间
System.out.println(st);
```

LocalDate年月日

LocalTime时分秒

LocalDateTime年月日时分秒

5、Instant

Instant.now()//

获取从1970年1月1日的总秒数和不够一秒的纳秒数

6、DateTimeFormatter时间格式转换

```
DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a");
LocalDateTime ldt=LocalDateTime.now();
System.out.println(ldt);
String result=ldt.format(dtf);
System.out.println(result);
//另一种写法
String result2=dtf.format(ldt);
System.out.println(result2);

//其他时间格式转换
String datetime="2025-11-16 12:12:12";
DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime ldt2=LocalDateTime.parse(datetime,dtf2);
System.out.println(ldt2);
```

7、Period，Duration

Period计算两个时间间隔的年月日数；Duration**计算两个时间相差的天数、小时数、分数、秒数、纳秒数**

```
LocalDateTime start=LocalDateTime.of(2025,3,20,12,28,10);
LocalDateTime end=LocalDateTime.of(2025,3,20,12,29,11);
//1、得到Duration对象
Duration duration= Duration.between(start,end);
//2、计算两个时间间隔
System.out.println(duration.toDays());
System.out.println(duration.toHours());
System.out.println(duration.toMinutes());
System.out.println(duration.toMillis());
System.out.println(duration.toSeconds());
System.out.println(duration.toMillis());
System.out.println(duration.toNanos());
```

若要显示间隔多少小时多少分多少秒

```
System.out.println(duration.toDays()+"天"+duration.toHoursPart()+"时"+duration.toSecondsPart()+"分"+duration.toMillisPart()+"秒");
```