package com.lily.d5_list;

import java.util.StringJoiner;

public class MyLinkedList<E> {
    private int size = 0;
    MyLinkedList.Node<E> first;

    public static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean add(E e) {
        Node<E> newNode = new Node<>(e, null);

        if (first == null) {
            first = newNode;
        } else {
            Node<E> temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size += 1;
        return true;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        Node<E> temp = first;
        while (temp != null) {
            sj.add(temp.item + "");
            temp=temp.next;
        }
        return sj.toString();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }
}
class Test{
    public static void main(String[] args) {
        MyLinkedList<String> list=new MyLinkedList<>();
        list.add("Java1");
        list.add("Java2");
        list.add("Java3");
        System.out.println(list.toString());
    }
}

