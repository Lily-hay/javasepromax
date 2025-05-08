package homeWork.work1;

public class Test {
    public static void main(String[] args) {
        Manager m=new Manager("张三","heima001",13000,2000);
        System.out.print("工号为"+m.getName()+"的"+m.getName()+"项目经理"+"正在");
        m.work();
    }
}
