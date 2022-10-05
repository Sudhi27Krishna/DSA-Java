package com.company;


public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.display();
        list.insertRec(88,2);
        list.display();

////        System.out.println(list.deleteFirst());
////        System.out.println(list.deleteLast());
//        System.out.println(list.delete(2));
//        list.display();

//
//        CLL list = new CLL();
//        list.insert(23);
//        list.insert(3);
//        list.insert(19);
//        list.insert(75);
//        list.display();
//        list.delete(19);
//        list.display();

    }

}
