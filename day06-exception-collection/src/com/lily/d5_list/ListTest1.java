package com.lily.d5_list;

import java.util.LinkedList;

public class ListTest1 {
    public static void main(String[] args) {
        //1、双链表实现队列
        LinkedList<String> queue=new LinkedList<>();
        queue.addLast("第一个人");
        queue.addLast("第二个人");
        queue.addLast("第三个人");
        queue.addLast("第四个人");
        System.out.println(queue);
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        //2、实现栈
        LinkedList<String> stack=new LinkedList<>();
        stack.addFirst("第一颗子弹");//push
        stack.addFirst("第二颗子弹");
        stack.addFirst("第三颗子弹");
        stack.addFirst("第四颗子弹");
        System.out.println(stack);
        System.out.println(stack.removeFirst());//pop
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack);
    }
}
