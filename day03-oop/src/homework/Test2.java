package homework;

public class Test2 {
    public static void main(String[] args) {
        Inter i = new Inter() {
            @Override
            public void show() {
                System.out.println("匿名内部类 - show()");
            }

            @Override
            public void method() {
                System.out.println("匿名内部类 - method()");
            }

            public static void fun(){
                System.out.println("匿名内部类 - fun()");
            }
        };
        i.show();
    }
}
interface Inter{
    void show();
    default void method(){
        System.out.println("Inter - method()");
    }
    static void fun(){
        System.out.println("Inter - fun()");
    }
}