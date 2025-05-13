package homework;

public class Test {
    int c = 30;
    class Inner{
        int a = 10;
        public void show(){
            int b = 20;
            a = 100;
            b = 200;
            c = 300;
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }


    }
    public static void main(String[] args) {
        Test.Inner in=new Test().new Inner();
        in.show();
    }
}
