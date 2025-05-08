package homeWork.work1;

public class Test {
    public static void main(String[] args) {
        Manager m=new Manager("张三","heima001",13000,2000);
        System.out.print("工号为"+m.getJobNumber()+"的"+m.getName()+"项目经理,"+"拿着"+m.getSalary()+"的工资加"+m.getBonus()+"的奖金,"+"正在");
        m.work();
        Programmer p=new Programmer("李四","heima002",15000);
        System.out.print("工号为"+p.getJobNumber()+"的"+p.getName()+"程序员,拿着"+p.getSalary()+"的工资,");
        p.work();

    }
}
