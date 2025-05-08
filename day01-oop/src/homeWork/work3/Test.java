package homeWork.work3;

public class Test {
    public static void main(String[] args) {
        MainCard m=new MainCard(500,"12345678","张三");
        System.out.println("卡号为："+m.getCardId());
        System.out.println("户主为："+m.getName());
        m.depositMoney(600);
        m.drawMoney(700);
        m.drawMoney(1000);
        SecondCard m2=new SecondCard(400,"87654321","李四",1000);
        m2.depositMoney(100);
        m2.drawMoney(200);
        m2.drawMoney(1000);
        m2.drawMoney(100);
        m2.drawMoney(500);
    }
}
