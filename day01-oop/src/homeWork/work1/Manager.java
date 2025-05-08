package homeWork.work1;

public class Manager extends Staff{
    private double bonus;
    public Manager() {}

    public Manager(String name, String jobNumber, double salary, double bonus) {
        super(name, jobNumber, salary);
        this.bonus = bonus;
    }
    @Override
    public void work() {
        System.out.println("盯着程序员写代码");
    }
}
