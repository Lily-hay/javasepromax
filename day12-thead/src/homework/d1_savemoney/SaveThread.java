package homework.d1_savemoney;

public class SaveThread extends Thread{
    private  Account acc;

    public SaveThread(String name, Account acc)
    {
        super(name);
        this.acc=acc;
    }
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            acc.saveMoney(100);
        }
    }
}
