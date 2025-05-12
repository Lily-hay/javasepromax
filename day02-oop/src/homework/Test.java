package homework;

public class Test {


    public static void main(String[] args) {
            Other o = new Other();
            new Test().addOne(o);
        }
    public void addOne(final Other o) {//final定义后，值不能被修改

        System.out.println(o.i+3);
        }
    public static class Other {
        public int i;
    }

}
