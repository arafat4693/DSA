package kthdsa.F2;

public class IntListMain {
    public static void main(String[] args) {
        // Test default constructor
        IntList intList = new IntList();
        System.out.println("Default Constructor: " + intList);

        // Test add method
        intList.add(5);
        intList.add(10);
        intList.add(15);
        System.out.println("After add: " + intList);

        // Test add at specific index
        intList.add(1, 8);
        System.out.println("After add at index 1: " + intList);

        // Test get method
        int elementAtIndex2 = intList.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2);

        // Test indexOf method
        int index = intList.indexOf(10);
        System.out.println("Index of element 10: " + index);

        // Test remove method
        int removedElement = intList.remove(1);
        System.out.println("Removed element at index 1: " + removedElement);
        System.out.println("After remove: " + intList);

        // Test set method
        intList.set(0, 3);
        System.out.println("After set at index 0: " + intList);

        // Test size method
        int size = intList.size();
        System.out.println("Size of the list: " + size);

        // Test reallocate method
        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }
        System.out.println("After reallocate: " + intList);
    }
}
