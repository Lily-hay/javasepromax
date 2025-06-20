package com.lily.d1_junit;

import org.junit.*;

public class StringUnitTest {
    @Before
    public void before()//修饰实例方法，每个测试方法执行一次
    {
        System.out.println("============before=========");
    }
    @After
    public void after()
    {
        System.out.println("============after=========");
    }
    @BeforeClass
    public static void beforeClass()//修饰静态方法，所有测试方法前后执行一次
    {
        System.out.println("==========beforeClass========");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("===========afterClass=========");
    }

    @Test
    public void testPrintNumber()
    {
        StringUtil.printNumber(null);
        StringUtil.printNumber("");
        StringUtil.printNumber("admin");
    }
    @Test
    public void testGetMaxIndex()
    {
        /*System.out.println(StringUtil.getMaxIndex(null));
        System.out.println(StringUtil.getMaxIndex(""));
        System.out.println(StringUtil.getMaxIndex("admin"));*/
        int i1=StringUtil.getMaxIndex(null);
        Assert.assertEquals("null测试失败！",-1,i1);
        int i2=StringUtil.getMaxIndex("");
        Assert.assertEquals("空字符串测试失败！",-1,i2);
        int i3=StringUtil.getMaxIndex("admin");
        Assert.assertEquals("admin测试失败！",4,i3);
    }
}
