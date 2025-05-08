package homeWork.work3;

public class MainCard {
    private double money;
    private String cardId;
    private String name;

    public MainCard() {
    }

    public MainCard(double money, String cardId, String name) {
        this.money = money;
        this.cardId = cardId;
        this.name = name;
    }
    public void drawMoney(double money)
    {

        if(getMoney()<money)
        {
            System.out.println("You don't have enough money");
            return ;
        }
        setMoney(getMoney()-money);
        System.out.println("取款成功，您的余额为: "+getMoney());
    }
    public void depositMoney(double money)
    {
        setMoney(getMoney()+money);
        System.out.println("存钱后，您的余额为：: "+getMoney());
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
