package homework;
interface Intern {
    void show();
}
class Outer {
    //补齐代码，要求在控制台输出”HelloWorld”
    public static Intern method()
    {
        return new B();
    }
}

class B implements Intern{
    public void show(){
        System.out.println("HelloWorld");
    }
}
public class Test4 {
    public static void main(String[] args) {
        Outer.method().show();
    }
}

