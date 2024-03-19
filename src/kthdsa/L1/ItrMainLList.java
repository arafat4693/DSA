package kthdsa.L1;

import java.util.Iterator;

public class ItrMainLList {
    public static void main(String[] args) {
//        MyLinkedListItr<Integer> list = new MyLinkedListItr<>();
        MyLinkedListItr<String> l = new MyLinkedListItr<>();
        for (int i = 0; i < 9; i++) l.add("e" + i);
//        Iterator<String> iter = l.iterator();
//        iter.next();
//        iter.next();
//        iter.remove();
//        iter.next();
//        iter.remove();
        System.out.println(l.getSize());
    }
}
