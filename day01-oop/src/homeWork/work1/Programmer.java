package homeWork.work1;

public class Programmer extends Staff{
    public Programmer(){}

    public Programmer(String name, String jobNumber, double salary) {
        super(name, jobNumber, salary);
    }
    @Override
    public void work(){
        System.out.println("苦逼写代码");
    }
}
