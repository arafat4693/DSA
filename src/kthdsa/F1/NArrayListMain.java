package kthdsa.F1;

public class NArrayListMain {
    public static void main(String[] args) {
        // Create an instance of NArrayList
        NArrayList<String> arrayList = new NArrayList<>();

        // Test add() method
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        System.out.println("Initial ArrayList: " + arrayList);

        // Test get() method
        System.out.println("Element at index 1: " + arrayList.get(1));

        // Test add(int index, E element) method
        arrayList.add(1, "Inserted");
        System.out.println("After inserting at index 1: " + arrayList);

        // Test remove() method
        String removedElement = arrayList.remove(2);
        System.out.println("Removed element at index 2: " + removedElement);
        System.out.println("After removal: " + arrayList);

        // Test indexOf() method
        int index = arrayList.indexOf("Two");
        System.out.println("Index of 'Two': " + index);

        // Test set() method
        String oldValue = arrayList.set(0, "NewOne");
        System.out.println("Old value at index 0: " + oldValue);
        System.out.println("After setting at index 0: " + arrayList);
    }
}
