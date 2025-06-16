package homework.d1_savemoney;

public class Account {
    private int leftMoney=1000;

    public synchronized void saveMoney(int money) {
        String name=Thread.currentThread().getName();
        leftMoney+=money;
        System.out.println(name+"存入100快，余额为"+leftMoney);
    }
}
