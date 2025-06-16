package homework.d1_savemoney;

public class Test {
    public static void main(String[] args) {
        Account acc=new Account();
        new SaveThread("小王",acc).start();
        new SaveThread("小李",acc).start();
    }
}
