package homework;

public class Test3 {
    private class Inner{
        public Inner(){
            System.out.println("AAAA");
        }
    }
    public Test3(){
        Inner i = new Inner();
        System.out.println("BBBB");
    }

    public static void main(String[] args) {
        Test3 d = new Test3();
    }
}
