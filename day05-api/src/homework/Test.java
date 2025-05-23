package homework;

public class Test {
    public static void main(String[] args) {
        show(( a, b)->a+b);
    }
    public static void show(Calc calc)
    {
        int sum= calc.sum(10,20);
        System.out.println(sum);
    }
}
interface Calc{
    int sum(int a, int b);
}
