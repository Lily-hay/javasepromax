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

### 1、时间日期

1、StringBuilder

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

2、StringJoiner

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

3、Math、Runtime、System

Runtime可以获知虚拟机的内存以及电脑可用的

System.currnetTime.Mills时间毫秒值

4、BigDecimal

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

### 2、Arrays

操作数组的工具类

```
//掌握操作数组Arrays类的常用方法
int[] arr={11,5,22,67,2};

//1、返回数组内容
String result= Arrays.toString(arr);
System.out.println(result);

//2.得到数组内容的一个新数组，并返回新数组
int[] arr2=Arrays.copyOfRange(arr,1,4);
System.out.println(Arrays.toString(arr2));

//3、扩容,长度增加
int[] arr3=Arrays.copyOf(arr,10);
System.out.println(Arrays.toString(arr3));

double[] scores={100,78,90,98.5,88};
//4、修改数组中每个数据并存入
Arrays.setAll(scores, new IntToDoubleFunction() {
    @Override//匿名内部类
    public double applyAsDouble(int index) {
        return scores[index]+=10;
    }

});
System.out.println(Arrays.toString(scores));

//5、排序
Arrays.sort(scores);//从小到大
System.out.println(Arrays.toString(scores));
```



对类进行排序的两种方法

方法一：先在对象类中实现Comparable接口，再重写CompareTo方法

方法二：在调用Arrays.sort()方法时，直接声明匿名内部类

```
Arrays.sort(students, new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getHeight()> o2.getHeight())
            return 1;
        else if(o1.getHeight()<o2.getHeight())
            return -1;
        return 0;
    }
});
```

### 3、Lambda表达式

**简化匿名内部类的代码写法**

Lambada表达式只能简化**函数式接口**的匿名内部类（仅有一个抽样方法的接口）

```
Swimming s2=()->{
    System.out.println("老师跑得快------");
};
```

Lambada的省略规则

**参数类型可以省略不写**

**只有一个参数时**，参数类型可以省略不写，**同时()也可以省略**

如果Lambada表达式中的**方法体只有一行代码**，可以省略大括号不写，同时省略分号，若这行代码是return，也要省略return不写

```
Arrays.sort(students, ( o1,  o2)-> Double.compare(o1.getHeight(),o2.getHeight()));//Lamaba表达式最终简化写法
```

### 4、方法引用

**方法引用**（Method Reference）是 Java 8 引入的一种简洁语法，用于**替代 Lambda 表达式**，当 Lambda 的**实现就是调用某个已有方法**时，方法引用能让代码更简洁、易读。

静态方法引用

如果Lambda表达式里**只有一个静态方法**，并且**前后参数一致**，就可以使用静态方法引用

```
Arrays.sort(students, ( o1,  o2)-> Student.compareByHeight(o1,o2));
```

```
Arrays.sort(students,  Student::compareByHeight);//静态引用简化形式
```

Student.compareByHeight(o1,o2)方法对Double.compare(o1.getHeight(),o2.getHeight())进行了封装

实例方法引用

```
Test2 t=new Test2();
Arrays.sort(students,  t::compare);
```

特例类型的方法引用

如果一个Lamba表达式里**只调用一个实例方法**，并且前面参数列表中的**第一个参数是作为方法的主调**，后面的所有参数都是作为该实例方法入参的，则可以使用特定类型的方法引用

```
Arrays.sort(names,( o1, o2)->o1.compareToIgnoreCase(o2));
Arrays.sort(names,String::compareToIgnoreCase);
```

构造器引用

如果某个Lambda表达式里只是在创建对象，并且前后参数一致，就可以使用构造器引用

```
/*Create c1=new Create() {
    @Override
    public Car createCar(String name) {
        return new Car(name);
    }
};*/
//简化
//Create c1=(String name)->new Car(name);
//再简化
Create c1=Car::new;
```


### 5、正则表达式

![正则表达式](E:\javaprojects\javasepromax\笔记图片\正则表达式.jpg)

```
String data="欢迎张全蛋光临本系统！他删库并跑路了！欢迎李二狗光临本系统！"+
        "欢迎马六甲光临本系统！他浏览量好多照片！欢迎夏洛克光临本系统！他在六点送出了嘉年华！";
Pattern pattern=Pattern.compile("欢迎(.*?)光临");
Matcher matcher=pattern.matcher(data);
while(matcher.find())
{
    String sr=matcher.group(1);
    System.out.println(sr);
}
```

"欢迎(.*?)光临"中间的括号表示分组

## 3、异常

Error:代表系统级错误，不用管

Exception:异常，通常用Exception以及它的孩子来封装程序出现的问题

运行时异常：RuntimeException及其子类，编译时不会出现，运行时出现

数组越界异常、空指针异常、数字操作异常(除零)、类型转换异常等

编译时异常：编译阶段就会出现错误提醒的(如日期解析异常)

1、异常的作用

用来查询系统Bug的关键参考信息

可以作为方法内部的一种特征返回值，以便通知上层调用者底层的的执行情况

2、自定义异常

自定义运行时异常：继承RuntimeException,重写前两个方法，常使用

编译时异常：继承Exception,重写前两个方法

```
public class AgeIllegalRuntimeException extends RuntimeException{
    public AgeIllegalRuntimeException() {
    }

    public AgeIllegalRuntimeException(String message) {
        super(message);
    }
}
```

```
public static void main(String[] args) {
    try {
        save(200);
    } catch (AgeIllegalException e) {
        throw new RuntimeException(e);
    }

}
public static void save(int age) throws AgeIllegalException {
    //throw方法内使用，创建异常抛出去
    //throws方法上使用，异常抛给调用者
    if(age<0||age>150)
    {
        throw new AgeIllegalException("/age is wrong");
    }
    System.out.println("年龄保存成功！");
```
3、开发中对于异常的处理

![793ba678cdc110a81c7aae5f0e4b66e](C:\Users\DL\Documents\WeChat Files\wxid_in4ab2xn7v9h22\FileStorage\Temp\793ba678cdc110a81c7aae5f0e4b66e.jpg)

## 4、集合

### 1、集合体系结构

Collection集合体系 单列集合的祖宗接口         

Map 双列集合，每个元素包含两个值(键值对)

![e01083117ef9d9c0e3d81ed1d8f4dd2](C:\Users\DL\Documents\WeChat Files\wxid_in4ab2xn7v9h22\FileStorage\Temp\e01083117ef9d9c0e3d81ed1d8f4dd2.jpg)



### 2、Collection的常用方法

```
//2、清空集合
//list.clear();
//System.out.println(list);

//3、判断集合是否为空
System.out.println(list.isEmpty());

//4、直接删除集合中某个元素
System.out.println(list.remove("张无忌"));
System.out.println(list);

//5、判断是否包含某个数据
System.out.println(list.contains("java1"));

//6、获取集合的大小
System.out.println(list.size());

//7、把集合转为数组
Object[] array=list.toArray();//防止有其他类型的数据
System.out.println(Arrays.toString(array));
//拓展
String[] array1=list.toArray(String[]::new);
System.out.println(Arrays.toString(array1));

//拓展，将别人集合加到自己这里
Collection<String> c1=new ArrayList<>();
c1.add("java1");
c1.add("java2");
Collection<String> c2=new ArrayList<>();
c2.add("java2");
c2.add("java3");
c1.addAll(c2);
System.out.println(c1);
```

### 3、Collection的遍历方式

**迭代器是用来遍历集合的专用方式(数组没有)**

```
Iterator<String> it=list.iterator();
while(it.hasNext())
{
    String ele=it.next();
    System.out.println(ele);
```

增强for循环（本质是迭代器）

既可以遍历集合，也可以遍历数组

```
for (String s : list) {
    System.out.println(s);
}

int[] ages={12,24,45,6};
for (int age : ages) {
    System.out.println(age);

}
```

Lambda表达式遍历

```
list.forEach(new Consumer<String>() {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
});

list.forEach(( s)->System.out.println(s));

list.forEach(System.out::println);
```

遍历的并发修改异常

遍历集合时，同时删除数据

仅可用迭代器遍历，其他两种底层也是迭代器，不可解决bug

用迭代器自己的删除方法删除数据，不能用集合的方法删

能用for循环删除时，从后遍历删除或者删除之后i---

```
Iterator<String> it=list1.iterator();
while(it.hasNext()){
    String ele=it.next();
    if(ele.contains("枸杞"))
    {
        it.remove();
    }
}
```

### 4、List集合

支持索引，可用for循环遍历

特有方法

```
//2、给某个位置插入数据
list.add(2,"小周");
System.out.println(list);

//3、根据索引删除数据
System.out.println(list.remove(2));

//4、修改索引位置数据
list.set(2,"小花");
System.out.println(list);

//5、根据索引取数据
System.out.println(list.get(1));
```

1、ArrayList

基于数组实现，根据地址和索引值查数据

根据索引查数据快，适合于数据量不大，不频繁增删数据

底层原理：一开始add时创建一个长度为10的数组，后面长度不够，扩容为原来长度的1.5倍，再把数据移过来，如果加入的数据大于1.5倍，则扩容到总数据长度

2、LinkedList集合

基于双链表实现，查询慢、增删较快，但**对首尾元素增删改查的速度是极快的**

方便栈和队列的操作

```
//1、双链表实现队列
LinkedList<String> queue=new LinkedList<>();
queue.addLast("第一个人");
queue.addLast("第二个人");
queue.addLast("第三个人");
queue.addLast("第四个人");
System.out.println(queue);
System.out.println(queue.removeFirst());
System.out.println(queue.removeFirst());
System.out.println(queue.removeFirst());
System.out.println(queue);

//2、实现栈
LinkedList<String> stack=new LinkedList<>();
stack.addFirst("第一颗子弹");//push
stack.addFirst("第二颗子弹");
stack.addFirst("第三颗子弹");
stack.addFirst("第四颗子弹");
System.out.println(stack);
System.out.println(stack.removeFirst());//pop
System.out.println(stack.removeFirst());
System.out.println(stack.removeFirst());
System.out.println(stack);
```

### 5、set集合

无序、**不重复**、无索引



1、HashSet 

无序、无索引，不重复

哈希值：对象的随机数，不同对象的哈希值一般不同，但也会出现哈希碰撞

**哈希表是一种增删改查性能都较好的结构**

jdk8之前结构为数组+链表

jdk8之后为：数组+链表+红黑树（链表长度大于8）

二叉查找树：**当数据已经排好了之后，导致查询性能更单链表一样，速度慢**

平衡二叉树：在满足二叉查找树条件下，减少树的深度，改善查询性能，红黑树也是一种平衡二叉树

HashSet默认不能对内容一样的的不同对象去重，需要重写haseCode()方法和equals方法，在比较时是内容生成哈希值，而不是整个对象

需要内容和哈希值都相同



2、LinkedHashSet **有序**、无索引、不重复

依然是基于哈希表（数组、链表、红黑树）实现

但是，**它的每个元素都额外多了一个双链表的机制来记住前后元素的位置**，因此有序

3、TreeSet **可排序**、无索引、不重复

底层是基于红黑树实现的

同样不可直接对对象进行排序，可继承Compare接口，重写compareTo方法或TreeSet自带的匿名接口

### 6、Collection的其他知识

1、可变参数

一种特殊形参，定义在方法、构造器的形参列表中，格式：**数据类型...参数名称**

好处：不传参数给它，可以传参数，可以传一个、也可以传多个，接受数据非常灵活

本质：在方法内部本质是一个数组

注意：可变参数在形参列表中只能出现一个！必须放在形参列表的最后！

2、Collections工具类

```
//1、
Collections.addAll(names,"张无忌","小张","赵敏");

//2、
Collections.shuffle(names);
System.out.println(names);
//3、
Collections.sort(list,((o1,o2)->Double.compare(o1.getHeight(),o2.getHeight())));
```

新生成getter与setter，构造器的方法，

```
import lombok.AllArgsConstructor;
import lombok.Data;//包含(无参+get+set+equals+hashCode+toString)
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
```

### 7、Map集合

键值对集合：键不能重复，值可以重复

Map系列集合的特点都是由键决定的

```
Map<String,Integer> map = new HashMap<>();
map.put("Java入门",1);
map.put("iphone16pro",1);
map.put("xiaomi15",5);
map.put("doal",2);
map.put("xiaomi15",10);
System.out.println(map);
```

常用方法

```
//1、获取集合长度
    System.out.println(map.size());

    //2、清空集合
    /*map.clear();
    System.out.println(map);*/

    //3、格局键获取相应的值
    System.out.println(map.get("xiaomi15"));
    map.get("xiaomi");

    //4、根据键删除整个数据，返回被删除对象对应的值
    System.out.println(map.remove("xiaomi15"));
    System.out.println(map);

    //5、判断键是否包含某个值
    System.out.println(map.containsKey("xiaomi15"));
    System.out.println(map.containsKey("doal"));

    //6、判断值包含某个值
    System.out.println(map.containsValue(1));
    System.out.println(map.containsValue(2));

    //7、判断集合是否为空
    System.out.println(map.isEmpty());

    //8、获取Map的全部键，到一个Set集合
    Set<String> keys=map.keySet();
    System.out.println(keys);
    
    //9、获取Map的所有值到一个Collection集合
    Collection<Integer> values=map.values();
    System.out.println(values);
}
```

遍历方式

```
//1、键找值
 Map<String,Integer> map = new HashMap<>();
 map.put("Java入门",1);
 map.put("iphone16",1);
 map.put("小米",5);
 map.put("布偶",2);
 map.put("华为",10);
 Set<String> keys = map.keySet();
 for (String key : keys) {
     int value = map.get(key);
     System.out.println(key + ":" + value);
 }

 //2、键值对,先将Map集合转为Set集合，将键值封装成一个整体的Entray对象
 Set<Map.Entry<String,Integer>> entries = map.entrySet();
 for (Map.Entry<String, Integer> entry : entries) {
     String key=entry.getKey();
     int value=entry.getValue();
     System.out.println(key + ":" + value);
 }
 
 //3、Lambda
/* map.forEach(new BiConsumer<String, Integer>() {
     @Override
     public void accept(String key, Integer value) {
         System.out.println(key + ">>>" + value);
     }
 });*/
 map.forEach((k,v)->{
     System.out.println(k + ">>>" + v);
 });
```

HashMap

无序、不重复、无索引

对象要通过HashCode和Equals方法去重保证唯一性

LinkedHashMap

有序、不重复、无索引

实际上：原来学习的LinkedHashSet集合的底层原理就是LinkedHashMap

TreeMap

红黑树排序

集合嵌套

如Map里的值可以存多个，存成一个集合

## 5、Stream

新的API，可以用于操作集合或者数组中哦的数据

结合了大量Lambda表达式的语法风格，代码更简洁、可读性更好

步骤：1、得到集合或数组的Stream流

​	    2、调用Steam流对数据进行操作

​	    3、获取Stream的处理结果	

1、获取Stream流

```
Collection<String> list= new ArrayList<>();
Collections.addAll(list,"张无忌","赵敏","周芷若","张强","张三丰");
Stream<String> s1=list.stream();
System.out.println(s1.count());

//2、获取Map集合的Stream流
Map<String,Integer> map=new HashMap<>();
//获取键流  
Stream<String> s2=map.keySet().stream();
//获取值流
Stream<Integer> s3=map.values().stream();
//获取键值对流
Stream<Map.Entry<String,Integer>> kv=map.entrySet().stream();

//3、获取数据的Stream流
String[] names={"赵敏","周芷若","张强","张三丰"};
Stream<String> as = Arrays.stream(names);
Stream<String> as1 = Stream.of(names);
```



2、Stream流的常用功能

```
//1、过滤集合
Collection<String> list= new ArrayList<>();
Collections.addAll(list,"张无忌","赵敏","周芷若","张强","张三丰");
list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);

//2、排序
List<Movie> movies=new ArrayList<>();
Movie m1=new Movie("三傻大闹宝莱坞",8.8,"阿米尔汗2");
Movie m3=new Movie("三傻大闹宝莱坞",8.8,"阿米尔汗2");
Movie m2=new Movie("摔跤吧，爸爸",9.5,"阿米尔汗");
Movie m4=new Movie("阿甘正传",7.5,"汤姆汉克斯");
Collections.addAll(movies,m1,m2,m3,m4);
movies.stream().sorted((o1,o2)->Double.compare(o1.getScore(),o2.getScore())).forEach(System.out::println);

//3、limit取几个
System.out.println("===================");
movies.stream().limit(3).forEach(System.out::println);

//4、skip跳过前几个
System.out.println("===========================");
movies.stream().skip(3).forEach(System.out::println);

//5、distinct去重,要求重写equals,hashCode方法
System.out.println("==============================");
movies.stream().distinct().forEach(System.out::println);

//6、map加工方法，将流上的数据加工成新数据
System.out.println("=============================");
movies.stream().map(m->m.getName()+"====>"+m.getScore()).forEach(System.out::println);

//7、合并流，同一类型的流或者接受数据变成泛型
Stream<String> s1=Stream.of("张三","楚留香","西门吹牛");
Stream<String> s2 = Stream.of("李四", "石观音");
Stream<String> s = Stream.concat(s1, s2);
System.out.println(s.count());
```



3、Stream的终结方法

forEach,count,min,max

4、收集Stream流，返回数组或集合

```
List<String> list=new ArrayList<>();
Collections.addAll(list,"张无忌","赵敏","周芷若","张强","张三丰","张三丰");
Stream<String> s1=list.stream();//流只能用一次
//1、收到list集合
List<String> newlist=s1.filter(s->s.startsWith("张")&&s.length()==3).collect(Collectors.toList());
System.out.println(newlist);

//2、收集到Set集合
Stream<String> s2 = list.stream();
Set<String> set = s2.filter(s -> s.startsWith("张")).collect(Collectors.toSet());
System.out.println(set);

//3、收集到数组
Stream<String> s3= list.stream();
Object[] objects = s3.filter(s -> s.startsWith("张")).toArray();
System.out.println(Arrays.toString(objects));

//4、收集到Map集合
List<Movie> movies=new ArrayList<>();
Movie m1=new Movie("三傻大闹宝莱坞",8.8,"阿米尔汗2");
Movie m3=new Movie("三傻大闹宝莱坞",8.9,"阿米尔汗2");
Movie m2=new Movie("摔跤吧，爸爸",9.5,"阿米尔汗");
Movie m4=new Movie("阿甘正传",7.5,"汤姆汉克斯");
Collections.addAll(movies,m1,m2,m3,m4);
//报错Duplicate key，二分合并
Map<String,Double> map= movies.stream().limit(3).collect(Collectors.toMap(m11->m11.getName(),m22->m22.getScore(),(v1,v2)->v2));
System.out.println(map);
```

## 6、File

1、File的常用方法

```
    //1、判断文件是否存在
    System.out.println(f.exists());

    //2、判断是否是文件
    System.out.println(f.isFile());

    //3、判断是否是文件夹
    System.out.println(f.isDirectory());

    //4、获取文件的名称
    System.out.println(f.getName());

    //5、获取文件大小，返回字节数
    System.out.println(f.length());

    //6、获取文件的最后修改时间
    long time=f.lastModified();
    DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
    //先将long类型转换为LocalDateTime对象
    LocalDateTime ldt=LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault());
    String formattedTime=ldt.format(dft);
    System.out.println(formattedTime);

    //7、获取相对路径
    System.out.println(f.getPath());

    //8、获取绝对路径
    System.out.println(f.getAbsolutePath());
}
```

2、file的创建删除

```
//1、创建一个新文件
File f=new File("E:\\resource\\comlily.txt");
try {
    System.out.println(f.createNewFile());
} catch (IOException e) {
    throw new RuntimeException(e);
}

//2、创建新文件夹，只能创建一级文件夹
File f2=new File("E:\\resource\\eee66");
System.out.println(f2.mkdir());

//3、创建文件夹，可创建多级
File f3=new File("E:\\resource\\eee77\\ccc");
System.out.println(f3.mkdirs());

//4、只能删除文件和和空文件夹，不能删除非空文件夹
System.out.println(f.delete());
System.out.println(f2.delete());
System.out.println(f3.delete());
```

3、File的遍历

```
//1、list() 获取当前目录下的所有的“一级文件名称”到一个字符串数组中去返回
File f=new File("E:\\01-dll");
String[] names=f.list();
for (String name : names) {
    System.out.println(name);
}

//2、listFiles() 获取当前目录下所有的“一级文件对象”到一个文件对象数组中去返回
/*注意：当主调是文件或路径不存在时，返回null
*       当主调文件夹时空文件夹时，返回一个长度为零的数组
*       当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回
*       当主调是一个文件夹时，且里面有隐藏文件时，将里面所有文件和文件夹的路径在File数组中返回，包含隐藏文件
*       当主调是一个文件夹时，但是没有权限访问，返回null*/
File[] files=f.listFiles();
for (File file : files) {
    System.out.println(file);
}
```

4、文件搜索

前置知识：递归

递归的三要素:递归的公式，递归的终结点，递归的方向必须指向终结点

```
private static void searchFile(File dir, String fileName) {
    //1、搜索判断
    if(dir==null || !dir.exists() ||dir.isFile())
    {
        return;
    }
    //2、提取所有一级文件
    File[] files=dir.listFiles();
    if(files==null || files.length==0)
    {
        return;
    }
    //遍历
    for (File file : files) {
        if(file.isFile())
        { //是文件
            if(file.getName().contains(fileName))
            {
                System.out.println(file.getAbsoluteFile());
            }
        }
        else {
            //文件夹
            searchFile(file,fileName);   
        }
    }
```



## 7、IO流

前置知识：字符集

ASCALL码，一个字符占一个字节，GBK：中文的编码，一个字占两个字节

UTF-8：是Unicode字符集的一种编码方案，采取可变长编码方案，共分四个长度区：1个字节

![8da287146d0e7a85888b9f551972205](D:\java codes\javasepromax\笔记图片\8da287146d0e7a85888b9f551972205.jpg)

![848d2d2ac780c895ccc44c85131e6c1](E:\WeChat Files\wxid_in4ab2xn7v9h22\FileStorage\Temp\848d2d2ac780c895ccc44c85131e6c1.jpg)

![8da287146d0e7a85888b9f551972205](C:\Users\DL\Documents\WeChat Files\wxid_in4ab2xn7v9h22\FileStorage\Temp\8da287146d0e7a85888b9f551972205.jpg)

注意：字符编码使用的字符集，和解码使用的字符集要一致，否则会出现乱码

​		英文和数字不会出现乱码

编码解码

```
String info="abc我在黑马听磊哥说nb!";
//编码成字节
byte[] bytes=info.getBytes();
System.out.println(Arrays.toString(bytes));

byte[] bytes1=info.getBytes("GBK");
System.out.println(Arrays.toString(bytes1));

//解码成字符
String rs1=new String(bytes);
System.out.println(rs1);
String rs2=new String(bytes1,"GBK");
System.out.println(rs2);
```



IO流概述

作用:读写数据

I 指input，称为输入流:负责把数据读到内存中去，O指Output，称为输出流：负责写数据出去

按流中数据的最小单位，分为：字节流：适合所有类型的文件；字符流：只适合操作纯文本文件

总体就可分为四大流

![a1595ef9023b446da1a79cb2acfc18a](E:\javaprojects\javasepromax\笔记图片\a1595ef9023b446da1a79cb2acfc18a.jpg)

![5c24b79896be28ed0f63ff053925ae0](E:\javaprojects\javasepromax\笔记图片\5c24b79896be28ed0f63ff053925ae0.jpg)

![a1595ef9023b446da1a79cb2acfc18a](D:\java codes\javasepromax\笔记图片\a1595ef9023b446da1a79cb2acfc18a.jpg)

![f3cbf1a56112dbd11403f261c3432fe](D:\java codes\javasepromax\笔记图片\f3cbf1a56112dbd11403f261c3432fe.jpg)

字节流：适合做数据的转移，如复制

### 1、字节输入流

一次读一个字节

```
//InputStream is=new FileInputStream(new File("day09-io\\src\\didi.txt"));//完整写法
        InputStream is=new FileInputStream("day09-io\\src\\didi.txt") ;//简洁写法

        int b;//用于记住每次读取的字节
        while((b= is.read())!=-1)
        {
            System.out.print((char)b);
        }
        /* 拓展：
       1、代码性能差，一次只读取一个字节
       2、会截断汉字的字节
        * */
```

一次读多个字节

```
InputStream is=new FileInputStream("day09-io\\src\\didi1.txt");
byte[] buffer=new byte[3];//一次读取三个
/*int len=is.read(buffer);
System.out.println("内容："+new String(buffer));//下次读取还用同一个桶
System.out.println("长度："+len);
//要读取多少倒多少
int len2=is.read(buffer);
System.out.println("内容："+new String(buffer,0,len2));
System.out.println(len2);*/

//循环改进
int len;
while( (len=is.read(buffer))!=-1)
{
    System.out.println(new String(buffer,0,len));
}
/*拓展：
* 1、性能比较好
* 2、仍然没有解决汉字乱码的问题*/
```

一次读完全部字节

```
InputStream is=new FileInputStream("day09-io\\src\\didi2.txt") ;//简洁写法
File f=new File("day09-io\\src\\didi2.txt");
/*long size=f.length();
byte[] buffer=new byte[(int)size];
System.out.println("文件的大小："+size);
int len=is.read(buffer);
System.out.println("读取的字节:"+len);
System.out.println(new String(buffer));
*/
byte[] buffer=is.readAllBytes();
System.out.println(new String(buffer));
/*缺点：不能读取大一点的文件*/
```

字符流更适于读写文本文件

### 2、字节输出流

```
OutputStream os = new FileOutputStream("day09-io\\src\\didi3.txt");
os.write('a');
os.write(97);
os.write("\r\n".getBytes());
byte[] bytes="abc我爱你中国666".getBytes();
os.write(bytes);
os.write("\r\n".getBytes());
os.write(bytes,3,15);
//io流管道属于系统资源，会占用内存和相应的内存资源
//用完之后要关闭管道，释放被占用的内存资源
//os.flush();//刷新缓存在内存中的数据到磁盘中
os.close();//关闭包含刷新！
```

### 3、资源关闭的方式

finally代码区的特点：无论try中的程序正常执行还是出异常，即便是return了，最后都一定会执行finally区，除非JVM终止了

但finally区不能返回数据，否则会覆盖前面的数据

可将资源关闭放在finally区

```
InputStream is=null;
OutputStream os=null;
try {
    is = new FileInputStream("D:\\编程笔记\\kiss.png");
    os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");
    byte[] buffer = new byte[1024];
    int len;
    while ((len = is.read(buffer)) != -1) {

        os.write(buffer, 0, len);
    }
} catch (Exception e) {
    e.printStackTrace();
}
finally {
    try {
        os.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        is.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("复制完成");
}
```

太不简便，改进，try-with-resource,try小括号里定义资源

```
try(
	//这里只能放置资源对象，用完后会自动调用close关闭资源，这里的资源指实现类AutoCloseable接口
	InputStream is = new FileInputStream("D:\\编程笔记\\kiss.png");
    OutputStream os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");) {
    
    byte[] buffer = new byte[1024];
    int len;
    while ((len = is.read(buffer)) != -1) {
        os.write(buffer, 0, len);
    }
}catch(Exception e) {
        e.printStackTrace();
    }
}
```

### 4、字符输入流

![f3cbf1a56112dbd11403f261c3432fe](E:\javaprojects\javasepromax\笔记图片\f3cbf1a56112dbd11403f261c3432fe.jpg)

```
Reader fr= new FileReader("day10-io\\src\\com\\lily\\d1_char_stream\\llily.txt");
//2、读取一个字符回来，没有返回-1
/*int c1=fr.read();
System.out.println((char)c1);
int c2=fr.read();
System.out.println((char)c2);
int c3= fr.read();
System.out.println(c3);*/

//3、使用循环解决
int c;
while((c= fr.read())!=-1)
{
    System.out.println((char)c);
}
/*
* 解决了乱码的问题
* 性能较差*/
```

```
try (
        Reader fr= new FileReader("day10-io/src/com/lily/d1_char_stream/llily1.txt");
        ){
    char[] chs=new char[3];
    int len;
    while((len=fr.read(chs))!=-1)
    {
        String str=new String(chs,0,len);
        System.out.print(str);
    }
} catch (Exception e) {

    e.printStackTrace();
}
//性能较好
```

### 5、字符输出流

```
try (Writer fw = new FileWriter("day10-io\\src\\com\\lily\\d1_char_stream\\lily2.txt",true)) {
    //1、写一个字符出去
    fw.write('a');
    fw.write(98);
    fw.write("\r\n");
    //2、写一个字符串出去
    fw.write("我爱Java666");
    fw.write("\r\n");

    //3、写一个字符串的一部分出去
    fw.write("woai中国",4,2);
    fw.write("\r\n");
    //4、写一个字符数组出去
    char[] str="java".toCharArray();
    fw.write(str);
    fw.write("\r\n");
    //fw.flush();刷新缓冲区，刷新后，流可以继续使用
    //fw.close();关闭后流不可以使用

} catch (Exception e) {
    e.printStackTrace();
}
```

Writer fw = new FileWriter("day10-io\\src\\com\\lily\\d1_char_stream\\lily2.txt",true)

加了true,可以保留前面写的内容

### 6、缓冲流

![3a4650bfab8ccbe48a9fe82e37da56d](D:\java codes\javasepromax\笔记图片\3a4650bfab8ccbe48a9fe82e37da56d.jpg)

![3a4650bfab8ccbe48a9fe82e37da56d](E:\javaprojects\javasepromax\笔记图片\3a4650bfab8ccbe48a9fe82e37da56d.jpg)

原理：**字节缓冲输入流自带了8KB的缓冲池**，字节缓冲输出流也自带了8KB的缓冲池

字节缓冲输入流用法

```
try(InputStream is = new FileInputStream("D:\\编程笔记\\kiss.png");
    InputStream bis=new BufferedInputStream(is);
    OutputStream os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");
    OutputStream bos=new BufferedOutputStream(os);
    ) {

    byte[] buffer = new byte[1024];
    int len;
    while ((len = bis.read(buffer)) != -1) {
        bos.write(buffer, 0, len);
    }
}catch(Exception e) {
    e.printStackTrace();
}
```

字符缓冲流

**自带8K的字符缓冲池**

缓冲字符输入流

```
try (
        Reader fr= new FileReader("day10-io/src/com/lily/d1_char_stream/llily1.txt");
        //把低级的字符输入流包装成高级的字符缓冲输入流
        BufferedReader br=new BufferedReader(fr);
){
    /*char[] chs=new char[3];
    int len;
    while((len=br.read(chs))!=-1)
    {
        String str=new String(chs,0,len);
        System.out.print(str);
    }*/
    //缓冲字符流多一个功能，逐行读取（经典代码）
    String line;
    while((line=br.readLine())!=null)
    {
        System.out.println(line);
    }
} catch (Exception e) {

    e.printStackTrace();
}
```

缓冲字符输出流

```
try (
        Writer fw = new FileWriter("day10-io\\src\\com\\lily\\d1_char_stream\\lily2.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
) {
    //1、写一个字符出去
    bw.write('a');
    bw.write(98);
    //自带的换行功能
    bw.newLine();
    //2、写一个字符串出去
    bw.write("我爱Java666");
    bw.newLine();

    //3、写一个字符串的一部分出去
    bw.write("woai中国",4,2);
    bw.newLine();
    //4、写一个字符数组出去
    char[] str="java".toCharArray();
    bw.write(str);
    bw.newLine();
    //fw.flush();刷新缓冲区，刷新后，流可以继续使用
    //fw.close();关闭后流不可以使用

} catch (Exception e) {
    e.printStackTrace();
}
```

低级字节流按照数组形式复制通过加大buffer性能也会比较好，字节缓冲流加buffer性能也好

7、转换流

**若代码编码与被读取的文本文件的编码不一致，使用字符流读取文本文件会乱码**

字符输入转换流

**先获取文件的原始字节流，再将其按照真实的字符集编码转换成字符输入流，这样字符输入流就不乱码了**

```
InputStream is = new FileInputStream("D:\\编程笔记\\kiss.txt");
Reader isr=new InputStreamReader(is,"GBK");//按照指定编码转换成字符输入流
BufferedReader br=new BufferedReader(isr);//用高级的缓冲流包装
```

字符输出转换流

```
OutputStream os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");
Writer osr=new OutputStreamWriter(os,"GBK");
BufferedWriter bw=new BufferedWriter(osr);
```

### 8、打印流

![ab044668482d35a5f17fa1986b42901](D:\java codes\javasepromax\笔记图片\ab044668482d35a5f17fa1986b42901.jpg)

**作用：可以实现更方便、更高效地打印数据出去，能实现打印啥出去就是啥出去**

PrintStream和PrintReader的打印功能完全相同，

```
try(
        //PrintStream ps=new PrintStream("day10-io/src/com/lily/d4_print_stream/aka.txt");
        PrintWriter ps=new PrintWriter("day10-io/src/com/lily/d4_print_stream/aka.txt");
        ) {
    ps.print('a');
    ps.print(97);
    ps.print(true);
    ps.print("你好");
    ps.println("okk");
    ps.println("fine");

} catch (Exception e) {
    e.printStackTrace();
}
```

输出语句的重定向

```
//输入语句的重定向
System.out.println("红豆生南国");
PrintStream ps=new PrintStream(new FileOutputStream("day10-io/src/com/lily/aka1.txt"));
System.setOut(ps);
//后面输出的语句都在文件里了
System.out.println("春来生几支");
```

### 7、特殊数据流

允许把数据和其类型一并写出，写入与输入的格式要一致，适合于·通信使用·1

![717a3989259a817eac88c4f09fd8066](D:\java codes\javasepromax\笔记图片\717a3989259a817eac88c4f09fd8066.jpg)

```
try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("day10-io/src/com/lily/data.txt"))) {//写入
    dos.writeChar('a');
    dos.writeByte(97);
    dos.writeBoolean(true);
    dos.writeUTF("你好");


} catch (Exception e) {
    e.printStackTrace();
}
```

```
try(DataInputStream dis=new DataInputStream(new FileInputStream("day10-io/src/com/lily/data.txt"))) {//读取
    char c=dis.readChar();
    System.out.println(c);
    Byte b=dis.readByte();
    System.out.println(b);
    Boolean bl=dis.readBoolean();
    System.out.println(bl);
    String s=dis.readUTF();
    System.out.println(s);


} catch (Exception e) {
    e.printStackTrace();
}
```

### 8、对象序列化和反序列化

对象序列化：可以把Java对象进行序列化：把Java对象存到文件中去

对象要实现序列化接口，用transient的成员不会被序列化，或是要同时序列化过个对象，则用集合来装，自己实现类序列化接口

```
public class Student implements Serializable {
    private String name;
    private int age;
    //用transient修饰的不同被序列化
    private transient String password;
```

```
ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("day10-io/src/com/lily/object.txt"));//序列化
Student s=new Student("张三",27,"okk666",176.4);
oos.writeObject(s);
```

```
ObjectInputStream ois=new ObjectInputStream(new FileInputStream("day10-io/src/com/lily/object.txt"));//反序列化
Student s=(Student)ois.readObject();
System.out.println(s);
```

### 9、IO框架

导入common-io框架

```
//用IO框架实现
FileUtils.copyFile(new File("day10-io/src/com/lily/aka.txt"),new File("day10-io/src/com/lily/aka-new.txt"));
//FileUtils.copyDirectory();复制文件夹
//FileUtils.deleteDirectory();删除文件夹

//Java完成文件的复制
//Files.copy(Path.of("day10-io/src/com/lily/aka.txt"),Path.of("day10-io/src/com/lily/aka-new.txt"));
```

## 8、特殊文件和日志

特殊文件：属性文件.properties  .xml文件

存储有关系的数据，比如用户名和密码等，作为系统的配置文件，作为信息进行传输

日志文件：把程序运行的信息，记录到文件中，方便程序员定位bug，并了解程序的执行情况

### 1、属性文件

特点：1、都只有键值对   2、键不能重复   3、文件后缀一般是以.properties结尾的

![a1ef089ccce7f78cd84dd16af940e72](D:\java codes\javasepromax\笔记图片\a1ef089ccce7f78cd84dd16af940e72.jpg)

Properties属于Map集合，load方法加载属性文件信息

```
//1、创建对象
Properties p=new Properties();
System.out.println(p);
//2、加载
p.load(new FileInputStream("day11-special-file-log/src/user.properties"));
System.out.println(p);
//遍历
p.forEach((k,v)->
        System.out.println(k+">>>"+v));
System.out.println(p.getProperty("赵敏"));
```

```
Properties p = new Properties();
p.setProperty("zhangsan","127369");
p.setProperty("lisi","127369");
p.setProperty("小昭","wuji");
//存储
p.store(new FileOutputStream("day11-special-file-log/src/user1.properties"),"i save some user's password ");//注释
```

修改用户信息

```
Properties p=new Properties();
p.load(new FileReader("day11-special-file-log/src/people.txt"));
if(p.containsKey("李芳"))
{
    p.setProperty("李芳","18");
}
p.store(new FileWriter("day11-special-file-log/src/people.txt"),"change message");
System.out.println(p);
```

### 2、XML文件

本质是一种数据格式，可以用来存储复杂的数据结构和数据关系

特点：

1、”<标签名>"称为一个标签或一个元素，一般成对出现

2、标签名可自己定义，但必须正确嵌套

3、XML文件只能由有一个根标签

4、XML里的标签可以有属性id=

5、后缀.xml

![f3cbf1a56112dbd11403f261c3432fe](E:\javaprojects\javasepromax\笔记图片\f3cbf1a56112dbd11403f261c3432fe.jpg)

用dom4j架包读取XML文件

```
Element rootElement=document.getRootElement();
System.out.println(rootElement.getName());

//4、提取了元素对象
List<Element> sonEles=rootElement.elements("contact");
for (Element sonEle : sonEles) {
    System.out.println(sonEle.getName());
}

//给定获取单个子元素
Element userEle=rootElement.element("user");
System.out.println(userEle.getName());

Element contactEle=rootElement.element("contact");//默认拿第一个contact
System.out.println(contactEle.elementText("name"));

//5、提取子元素的属性对象
Attribute idAttr=contactEle.attribute("id");
System.out.println(idAttr.getName());
System.out.println(idAttr.getValue());

//6、文本值
//通过父元素拿到子元素文本值
System.out.println(contactEle.elementText("name"));
System.out.println(contactEle.elementTextTrim("name"));//去掉前后空格

//先拿到元素对象，再提取其文本值
Element emailEle=contactEle.element("email");
System.out.println(emailEle.getText());
System.out.println(emailEle.getTextTrim());
```

用dom4j读取XML文件

```
SAXReader saxReader=new SAXReader();
Document document=saxReader.read("day11-special-file-log/contact.xml");
Element rootElement=document.getRootElement();
List<Contact>  contacts=new ArrayList<>();
List<Element> sonEles=rootElement.elements("contact");
for (Element sonEle : sonEles) {
    Contact c=new Contact();
    c.setId(Integer.valueOf(sonEle.attributeValue("id")));
    c.setName(sonEle.elementTextTrim("name"));
    c.setGender(sonEle.elementTextTrim("gender").charAt(0));
    c.setEmail(sonEle.elementTextTrim("email"));
    contacts.add(c);
}
System.out.println(contacts);
```

写进XML文件，直接拼接字符串

```
StringBuilder sb=new StringBuilder();
sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
sb.append("<user>\r\n");
sb.append("\t<name>").append("张三").append("</name>\r\n");
sb.append("\t<age>").append("18").append("</age>\r\n");
sb.append("\t<sex>").append("男").append("</sex>\r\n");
sb.append("</user>\r\n");
PrintStream ps=new PrintStream("day11-special-file-log/user3.xml");
ps.println(sb);
ps.close();
```

约束XML文件的书写

DTD约束文档，不约束具体的数据类型

schema约束文档，约束具体的文件类型，后缀.xsd



### 3、日志

![日志](E:\javaprojects\javasepromax\笔记图片\日志.jpg)

![日志](D:\java codes\javasepromax\笔记图片\日志.jpg)

我们使用Logback，slf4j接口

实现步骤：

1、倒入Logback框架导入项目中

logback-core, logback-classic，sil4j

2、将Logback框架的核心配置文件logback.xml直接拷贝到src目录下

## 9、多线程

线程：一个程序内部的一条执行流程（CPU负责调度执行）

多线程：多条执行流程

### 1、创建线程

创建线程要继承Thread类，重写run方法

#### 创建方法一

多线程的注意事项：

1、启动线程必须调用start方法，不是调用run方法

~直接调用run方法会当成普通的方法执行，此时相当于单线程执行

~只有主调start方法才是启动一个新线程执行

2、不要把主线程放在启动子线程的前面

~这样一定是主线程先跑完，相当于单线程

```
public static void main(String[] args) {
Thread t=new MyThread();
//t.run//
t.start();
    for (int i = 0; i < 3; i++) {
        System.out.println("主线程输出："+i);
    }
}
```

```
class MyThread extends Thread
{
    @Override
    public void run(){
    for (int i = 0; i < 4; i++) {
        System.out.println("子线程输出了"+i);
    }
}
}
```

优点：编码简单

缺点：线程类已经继承Thread，无法再继承其他类，不利于功能拓展



#### 创建方法二

实现Runnable接口，重写run方法，但得到的是一个任务类对象，要将其包装成线程对象

优点：只用实现类，可以继续继承其他类，实现其他接口，功能扩展性很强

```
//1、创建任务类的一个对象
Runnable target=new NewThread();
//2、将任务类对象给子线程
Thread t=new Thread(target);
//3、启动子线程
t.start();
for (int i = 0; i < 3; i++) {
    System.out.println("主线程执行"+i);
}
```

```
class NewThread implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("子线程实现了"+i);
        }
    }
}
```

创建方法三

优点：线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强；**可以在线程执行完后获取线程执行的结果**

利用Callable接口、FutureTask类来实现

①创建任务对象：

​	定义一个类实现Callable接口，重写call方法，封装要做的事情，和要返回的数据

​	把Callable类型的对象封装成FatureTask(线程任务对象)

②把线程对象交给Thread对象

③调用start方法启动线程

④线程执行完毕，通过FutureTask对象的get方法去获取线程任务执行的结果

```
//1、定义一个类实现Callable接口
class MyCallable implements Callable
{
    private int n;
    public MyCallable (int n)
    {
        this.n=n;
    }
    int sum;
    @Override
    public String call() throws Exception {
        for (int i = 0; i < n; i++) {
            sum+=i;
        }
        return n+"个数的和为:"+sum;
    }
}
```

```
//2、创建一个Callable对象
Callable callable=new MyCallable(100);
//3、将Callable 对象封装为FutureTask对象
FutureTask<String> task=new FutureTask<>(callable);
//FutureTask两个作用：1、是一个Runnable对象  2、可以·返回值
Thread t=new Thread(task);
t.start();
try {
    String rs1 = task.get();
    System.out.println(rs1);
} catch (Exception e) {
    e.printStackTrace();
}
```

2、api



### 3、线程安全

出现的原因：1、存在多个线程同时执行；2、同时访问同一个共享资源；3、存在修改该共享资源

解决方法：

#### 1、同步代码块synchronized

作用：把访问的共享资源的核心代码給上锁，以此保证线程安全

原理：每次只允许一个线程加锁后进入，执行完毕后自动解锁，其他线程才能进

注意事项：对于当前同时执行的线程来说，同步锁必须是同一锁（**同一个对象**）

锁对象最好不要随便选，会影响其他无关线程的执行

锁对象使用规范：

1、**建议使用共享资源作为锁的对象**，对于实例方法建议使用this作为锁的对象

2、对于静态方法建议使用**字节码（类名.class）**对象作为锁对象

```
synchronized (this) {
    if(money<=this.money)
    {
        System.out.println(name+"成功取出"+money);
        this.money-=money;
        System.out.println(name+"剩余余额为"+this.money);
    }
    else
    {
        System.out.println(name+"取钱，余额不足！");
    }
}
```



#### 2、同步方法

对出现问题的核心方法使用synchronized修饰

每次只能一个·线程占锁访问

```
public synchronized void drawMoney(int money) {
    String name=Thread.currentThread().getName();

        if(money<=this.money)
        {
            System.out.println(name+"成功取出"+money);
            this.money-=money;
            System.out.println(name+"剩余余额为"+this.money);
        }
        else
        {
            System.out.println(name+"取钱，余额不足！");
        }

}
```

#### 3、Lock锁

更方便、灵活、强大

Lock是接口，不能直接实例化，可采用ReentrantLock来构建对象

```
private Lock lk=new ReentrantLock();
```

```
try {
    lk.lock();
    if(money<=this.money)
    {
        System.out.println(name+"成功取出"+money);
        this.money-=money;
        System.out.println(name+"剩余余额为"+this.money);
    }
    else
    {
        System.out.println(name+"取钱，余额不足！");
    }
} finally {
    lk.unlock();
}
```



#### 4、线程通信

当多个线程共同操作共享资源时，线程间通过某种方式相互告知自己的状态，以相互协调，并避免无效的资源争夺

常见模型（消费者和生产者模型）

**生产者生产完数据应该通知消费者，等待自己；消费者消费完数据后也应该唤醒别人，等待自己**

#### 5、线程池

**是一个可复用线程的技术**

如何得到线程池对象？

方法一：使用ExecutorServise的实现类ThreadPoolExecutor创建一个线程池对象

方法二：使用Executors(线程池工具类)调用方法返回不同特点的线程池对象

![线程池参数](E:\javaprojects\javasepromax\笔记图片\线程池参数.jpg)

![线程池参数](D:\java codes\javasepromax\笔记图片\线程池参数.jpg)

注意事项：

临时线程什么时候创建？

新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建

什么时候会拒绝新任务？

当核心线程和临时线程都在忙，任务队列也满了，新的任务过来时才开始拒绝

1、线程池处理Runnable对象

```
ExecutorService pool=new ThreadPoolExecutor(3,5,1, TimeUnit.MINUTES,
        new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
Runnable target=new MyRunnable();
pool.execute(target);//自动创建线程，并处理任务
pool.execute(target);
pool.execute(target);
pool.execute(target);//复用线程
pool.execute(target);
pool.execute(target);
pool.execute(target);//到了创建临时线程的时机
pool.execute(target);//
pool.execute(target);//超出线程最大数，拒绝新任务
```

2、处理Callable对象

```
ExecutorService pool=new ThreadPoolExecutor(3,5,1, TimeUnit.MINUTES,
        new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
Future<String> f1 = pool.submit(new MyCallable(100));
Future<String> f2 = pool.submit(new MyCallable(200));
Future<String> f3 = pool.submit(new MyCallable(300));
try {
    String s = f1.get();
    System.out.println(s);
} catch (Exception e) {
    e.printStackTrace();
}
```

3、使用Executors，是线程池的一个工具类

```
ExecutorService pool= Executors.newFixedThreadPool(3);
```

缺点：不适合大型项目中使用，没有限制任务对象个数，可能会产生风险，如内存溢出



#### 6、并发、并行

进程：正在运行的程序（软件）就是一个进程

线程属于进程，一个进程中同时运行多个线程

**进程中的多个线程其实是并发和并行执行的**

并发：CPU会轮询为系统的每个线程服务的，由于CPU切换的速度很快，给人的感觉是同时进行的，这就是并发

并行：在同一时刻，同时有多个线程在被CPU调度执行

7、线程的生命周期

![线程生命周期](E:\javaprojects\javasepromax\笔记图片\线程生命周期.jpg)

![线程生命周期](D:\java codes\javasepromax\笔记图片\线程生命周期.jpg)

## 10、网络编程

可以让设备中的程序与网络中的程序数据交互

基本的通信架构

CS（客户端、服务端）结构、BS（浏览器、服务端）结构

网络通信的关键三要素：

1、IP  设备在网络中的地址，是唯一标识

有IPv4（32位）和IPv6（128位）

域名IP在通信中会得到实际IP

公网IP是可以连接互联网的IP地址，内网IP：局域网IP，只能组织内部使用，192.168.开头的

特殊IP地址：127.0.0.1、localhost代表本机IP，指挥寻找当前所在主机

IP常用命令：ipconfig:查看本机IP地址，pring IP地址：检查网络是否连通

物理地址：设备自生产后的唯一标识

```
InetAddress ip=InetAddress.getLocalHost();//获取本机IP地址
System.out.println(ip.getHostAddress());
System.out.println(ip.getHostName());

//获取对方IP

InetAddress ip1=InetAddress.getByName("www.baidu.com");
System.out.println(ip1.getHostAddress());
System.out.println(ip1.getHostName());

//判断是否能联通
System.out.println(ip1.isReachable(5000));
```



2、端口  应用程序在设备中的唯一标识，被规定为一个16位二进制数

分类：

》周知端口：0~1023 被预先定义的知名应用占用

》**注册端口**：1024~49151，分配给用户进程或某些应用程序

》动态端口：49152~65535

**我们开发程序一般选择使用注册端口，且一个设备不能出现两个程序有相同的端口号，否则会出错**



3、协议  连接和数据在网络中传输的规则

**开放式网络互联标准：OSI网络参考模型**

![网络传输模型](D:\java codes\javasepromax\笔记图片\网络传输模型.jpg)

![网络传输模型](E:\javaprojects\javasepromax\笔记图片\网络传输模型.jpg)

传输层的两个通信协议

UDP（用户数据报协议）  TCP（传输控制协议）

特点：**无连接，不可靠**，通信效率高

不事先建立连接，数据按照包发，包含自己的IP、程序端口、对方的IP、对方的程序端口和数据（64KB内）等，发送方不管对方是否在线，若连接中断，数据容易丢失，对方收到数据也不返回确认  

单发单收

发送端

```
//1、创建发送端对象（抛韭菜的人）
DatagramSocket socket=new DatagramSocket();

//2、创建一个数据包对象，负责封装发送的数据（盘子）
/*
* 参数一：发送数据，字节数组
* 参数二：发送数据大小
* 参数三：目标IP地址
* 参数四：接收端端口号
* */
byte[] buffer="今晚一起吃个dinner,约吗？？".getBytes();
DatagramPacket packet=new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);
//3、发送数据
socket.send(packet);
System.out.println("发送完毕！");
//4、关闭资源
socket.close();
```

接收端

```
//1、创建接收端对象
DatagramSocket socket = new DatagramSocket(8888);
byte[] buffer=new byte[1024*64];
//2、创建接收盒子
DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
//3、接收数据
socket.receive(packet);
int len=packet.getLength();
//获取信息
String msg= new String(buffer,0,len);
System.out.println(msg);
InetAddress ip=packet.getAddress();
System.out.println("对方IP："+ip.getHostAddress());
System.out.println("对方端口："+packet.getPort());
socket.close();
```

TCP通信协议

特点：面向连接、可靠通信

TCP的最终目的：在不可靠的信道上实现可靠的传输

TCP主要有三个步骤实现可靠传输：三次握手建立连接（确认双发收发正常），传输数据进行确认，四次挥手断开连接

![TCP连接](D:\java codes\javasepromax\笔记图片\TCP连接.jpg)

!(D:\java codes\javasepromax\笔记图片\TCP断开.jpg)

![TCP断开](D:\java codes\javasepromax\笔记图片\TCP断开.jpg)

![TCP断开](E:\javaprojects\javasepromax\笔记图片\TCP断开.jpg)

客户端

```
System.out.println("==========客户端启动===========");
//1、创建客户端对象
Socket socket=new Socket("127.0.0.1",9999);
//2、获取输出流，发送数据
OutputStream os=socket.getOutputStream();
//3、将输出流包装成特殊数据输出流
DataOutputStream dos=new DataOutputStream(os);
Scanner sc = new Scanner(System.in);
while (true) {
    String msg=sc.nextLine();
    if("exit".equals(msg))
    {
        System.out.println("退出成功！");
        socket.close();
        break;
    }
    dos.writeUTF(msg);
    dos.flush();
}
```

服务器

```
System.out.println("===========服务器启动===========");
ServerSocket ss=new ServerSocket(9999);
Socket socket=ss.accept();
InputStream is=socket.getInputStream();
DataInputStream dis=new DataInputStream(is);
while (true) {
    String msg=dis.readUTF();
    System.out.println("收到的消息为："+msg);
    System.out.println("对方IP："+socket.getInetAddress().getHostAddress());
    System.out.println("对方端口："+socket.getPort());
    System.out.println("------------------------------------");
}
```

多收多发

子线程

```
private Socket socket;

public ServerReader(Socket socket)
{
    this.socket=socket;
}

@Override
public void run()
{
    try {
        InputStream is=socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        while (true) {
            String msg=dis.readUTF();
            System.out.println("收到的消息为："+msg);
            System.out.println("对方IP："+socket.getInetAddress().getHostAddress());
            System.out.println("对方端口："+socket.getPort());
            System.out.println("------------------------------------");

        }
    } catch (IOException e) {
        System.out.println("一个客户端下线了"+socket.getInetAddress().getHostAddress());
    }
}
11、Java高级技术
```


=======
BS结构

![9dc6606373851764ad66003b86d2c82](C:\Users\Administrator\Documents\WeChat Files\wxid_in4ab2xn7v9h22\FileStorage\Temp\9dc6606373851764ad66003b86d2c82.jpg)



## 11、Java高级技术

### 1、junit单元测试

测试方法，测试方法：公开的、无参数的、无返回的

```
@Test
public void testGetMaxIndex()
{
    /*System.out.println(StringUtil.getMaxIndex(null));
    System.out.println(StringUtil.getMaxIndex(""));
    System.out.println(StringUtil.getMaxIndex("admin"));*/
    int i1=StringUtil.getMaxIndex(null);
    Assert.assertEquals("null测试失败！",-1,i1);
    int i2=StringUtil.getMaxIndex("");
    Assert.assertEquals("空字符串测试失败！",-1,i2);
    int i3=StringUtil.getMaxIndex("admin");
    Assert.assertEquals("admin测试失败！",4,i3);
}
```

Junit注解

```
@Before
public void before()//修饰实例方法，每个测试方法执行一次
{
    System.out.println("============before=========");
}
@After
public void after()
{
    System.out.println("============after=========");
}
@BeforeClass
public static void beforeClass()//修饰静态方法，所有测试方法前后执行一次
{
    System.out.println("==========beforeClass========");
}

@AfterClass
public static void afterClass()
{
    System.out.println("===========afterClass=========");
}
```



### 2、反射

加载类，并允许以编程的方式解剖类中的各种成分（成员变量、方法、构造器等）

```
//反射第一步：获取Class对象
//1方式一，类名.class
Class c1=Student.class;
System.out.println(c1);

//2方式二，对象.getClass()
Student s=new Student();
Class c2=s.getClass();
System.out.println(c2);

//方式三，Class.forName(全类名)
Class c3=Class.forName("com.lily.d2_reflect.Student");
System.out.println(c3);
```
反射第二部，获得构造器

```
Class c=Cat.class;
//获取类的全部构造器对象
Constructor[] constructors=c.getDeclaredConstructors();
for (Constructor constructor : constructors) {
    System.out.println(constructor.getName()+">>>"+constructor.getParameterCount());
}
```

```
Class c= Cat.class;
//Constructor con1=c.getConstructor();不能拿私有的
Constructor con1=c.getDeclaredConstructor();//定位无参数
Constructor con2=c.getDeclaredConstructor(String.class,int.class);//定位有参数

//3、得到构造器的目的依然是初始化对象返回
Cat c1 =(Cat) con1.newInstance();
System.out.println(c1);

con2.setAccessible(true);//禁止访问权限（暴力反射），解决私有的构造器不能改变
Cat c2=(Cat)con2.newInstance("叮当猫",30);
System.out.println(c2);
```

反射第三步，获取成员对象

```
Class c=Cat.class;
//获取全部对象
Field[] fields=c.getDeclaredFields();
for (Field field : fields) {
    System.out.println(field.getType()+">>>"+field.getName());
}

//获取单个对象
Field fname=c.getDeclaredField("name");

//获取成员变量的作用依然是赋值、取值
fname.setAccessible(true);//暴力反射
Cat cat=new Cat();
fname.set(cat,"哆啦A梦");
String name = (String)fname.get(cat);
System.out.println(name);
```

反射第四步，获取成员方法

```
Class c=Cat.class;
Method[] methods=c.getDeclaredMethods();
//获取所有方法
for (Method method : methods) {
    System.out.println(method.getName()+">>>"+method.getParameterCount());
}

//获取单个方法
Method eat1=c.getDeclaredMethod("eat");
Method eat2=c.getDeclaredMethod("eat",String.class);

//获取方法的目的，执行
Cat cat=new Cat();
Object result = eat1.invoke(cat);
System.out.println(result);
eat2.setAccessible(true);//暴力反射
Object result2 = eat2.invoke(cat,"鱼儿");
System.out.println(result2);
```

### 3、反射的作用

可以在运行时得到一个类的全部成分然后操作

可以破坏封装性

也可以破坏泛型的约束性

更重要的用途：适合做Java高级框架

```
public static void saveObject(Object obj) throws Exception {
    //获取对象中的全部字段，对象中有多少个字段，我们不清楚，但反射可以解决
    PrintWriter pw=new PrintWriter(new FileWriter("day14-junit-reflect-annotation-proxy/src/obj.txt"));
    Class c=obj.getClass();
    String className=c.getSimpleName();//Student
    System.out.println(className);
    pw.println("~~~~~~~~~~~"+className+"~~~~~~~~~~");
    Field[] fields=c.getDeclaredFields();
    for (Field field : fields) {
        String name=field.getName();
        field.setAccessible(true);
        String value=field.get(obj)+"";
        pw.println(name+"="+value);
        System.out.println(name+"="+value);
    }
    pw.close();
}
```

### 4、注解

Java代码里的特殊标记，@Override,@Test等，作用：让其他程序根据注解信息决定怎么执行程序

注解本质是一个接口，Java中所有注解都是继承Annotation接口

自定义注解，若只有value一个值，可以省略名字不写

使用的@注解(...)其实就是一个实现类对象，实现了该注解以及Annotation接口

元注解：修饰注解的注解

@Target(ElementType.TYPE) 声明被修饰的注解只能在哪些范围内使用

@Retention(RetentionPolicy.RANTIME) 声明注解保留的周期



解析注解

判断类上、方法上、成员变量上是否存在注解，并把注解里的内容解析出来

```
public class AnnotationDemo2 {
    @Test
    public void parseClass() throws Exception {
        Class c=Demo.class;//先得到该类
        Method method=c.getDeclaredMethod("test1");
        if(c.isAnnotationPresent(MyTest4.class))//再判断该类上有没有注解
        {
            MyTest4 myTest4= (MyTest4) c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(myTest4.bbb());
            
        }
    }
    
}
@MyTest4(value="java",aaa=99,bbb={"study"})
class Demo{
    @MyTest4(value="无为而治",aaa=9.9,bbb={"心静","悟道"})
    public void test1()
    {
        
    }
}
```

### 5、代理

为类对象提供一个代理，为该对象做一些事情，然后再让该对象完成自己的工作，类似经纪人

类对象要实现接口，接口包装要实现的方法

```
public class ProxyUtil {
    public static StarService createProxy(Star s)
    {
    	//参数一：用于执行哪个类加载器去加载生成的代理类
        //参数二;用于指定代理类需要的接口，明星类实现类哪些接口，代理类就实现哪些接口
        //参数三：用来指定代理类如何去代理
        StarService proxy =(StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), s.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            	//用来声明代理对象要干的事
                //参数一：proxy接收到代理对象本身
                //参数二：method代表正在被代理的方法
                //参数三：args代表正在被代理的方法的参数
                String methodName = method.getName();
                if ("sing".equals(methodName)) {
                    System.out.println("准备话筒，收费20万！");
                } else if ("dance".equals(methodName)) {
                    System.out.println("准备场地，收款100万！");
                }
                Object result = method.invoke(s, args);


                return result;
            }
        });
        return proxy;
    }
```

```
Star s=new Star("杨超越");
//创建代理对象
StarService proxy= ProxyUtil.createProxy(s);
proxy.sing("红昭愿");
System.out.println(proxy.dance());
```
