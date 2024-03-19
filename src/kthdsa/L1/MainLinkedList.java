package kthdsa.L1;

import java.util.Iterator;

public class MainLinkedList {
    public static void main(String[] args) {
        // Skapa en instans av MyLinkedList
//        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        MyLinkedList<String> l = new MyLinkedList<>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        l.remove(3);
        l.add(0,"först");
        l.add("sist");
        System.out.println(l);
    }
}

