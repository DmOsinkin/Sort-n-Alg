package ru.dosinkin;

public class Main {

    public static void main(String[] args) {
        MyArray list = new MyArray(30);
        list.print();
        System.out.println("=================");
        list.insert(124);
        list.insert(2434);
        list.insert(234);
        list.insert(1342);
        list.insert(5312);
        list.insert(1212);
        list.insert(612);
        list.insert(712);
        list.insert(16);
        list.insert(1);
        list.insert(3452);
        list.insert(484);
        list.insert(48);
        list.insert(458353);

        list.print();

//        MyArray sortedList = new MyArray(20);
//        int inputelement = 0;
//        while (true) {
//            inputelement = list.removeMax();
//            System.out.println(inputelement);
//            if(inputelement == -1) break;
//            sortedList.insert(inputelement);
//        }
        list.choiceSort();
        list.print();
    }
}
