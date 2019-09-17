package ru.dosinkin;

public class Main {

    public static void main(String[] args) {
        MyArray list = new MyArray(10);
        list.print();
        System.out.println("=================");
        list.insert(124);
        list.insert(2434);
        list.insert(234);
        list.insert(12);

        list.print();

        System.out.println(list.removeMax());;

        list.print();
    }
}
