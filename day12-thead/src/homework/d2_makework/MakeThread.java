package homework.d2_makework;

public class MakeThread extends Thread{
    private final Work work;
    private int count=0;
    public MakeThread(String name, Work work)
    {
        super(name);
        this.work=work;
    }
    @Override
    public void run()
    {

        while(true)
        {

            synchronized (work) {
                if(work.getWorks()>0)
                {
                    int left= work.getWorks();

                    System.out.println(Thread.currentThread().getName()+"写了一次Hello World,总共还需要写"+(--left)+"次");
                    work.setWorks(left);
                    count++;
                }
                else
                {
                    break;
                }
            }

        }
        System.out.println(Thread.currentThread().getName()+"共写了"+count+"次");

    }

}
