package kthdsa.F1;

import java.util.ArrayList;
import java.util.Collections;

public class F1p1 {
    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
        // Alternative solution
//        for(int i = 0; i<aList.size(); i++){
//            if(aList.get(i).equals(oldItem)){
//                aList.set(i, newItem);
//            }
//        }

        Collections.replaceAll(aList, oldItem, newItem);
    }

    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("banana");
        stringList.add("date");

        // Print the original list
        System.out.println("Original List: " + stringList);

        // Replace "banana" with "orange"
        F1p1.replace(stringList, "banana", "orange");

        // Print the modified list
        System.out.println("List after replacement: " + stringList);
    }
}
