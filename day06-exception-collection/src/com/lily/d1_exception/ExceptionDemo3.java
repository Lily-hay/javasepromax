package com.lily.d1_exception;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        try {
            save(200);
        } catch (AgeIllegalException e) {
            throw new RuntimeException(e);
        }

    }
    public static void save(int age) throws AgeIllegalException {
        //throw方法内使用，创建异常抛出去
        //throws方法上使用，异常抛给调用者
        if(age<0||age>150)
        {
            throw new AgeIllegalException("/age is wrong");
        }
        System.out.println("年龄保存成功！");
    }
}
