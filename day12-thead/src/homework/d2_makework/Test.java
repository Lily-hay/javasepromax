package homework.d2_makework;

public class Test {
    public static void main(String[] args) {
        Work work=new Work();
        new MakeThread("小明",work).start();
        new MakeThread("小王",work).start();
    }
}
