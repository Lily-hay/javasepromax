package homeWork.work3;

public class SecondCard extends MainCard {
    private double limit;
    public SecondCard() {}

    public SecondCard(double money, String cardId, String name,double limit) {
        super(money, cardId, name);
        this.limit=limit;
    }
    @Override
    public void drawMoney(double money){
        if(getMoney()+getLimit()<money){
            System.out.println("您最多可透支"+getLimit()+"，您已超过了最大可透支的额度");
            return;
        }
        if(getMoney()<money)
        {

            double money1=getMoney()+getLimit()-money;
            setLimit(money1);
            System.out.println("余额为0，"+"剩余额度为："+money1);
            setMoney(0);
            return;

        }
        setMoney(getMoney()-money);
        System.out.println("取款成功，您的余额为: "+getMoney());

    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
