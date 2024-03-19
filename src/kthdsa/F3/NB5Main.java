package kthdsa.F3;

public class NB5Main {
    public static void main(String[] args) {
        NB5<Integer> stack = new NB5<>();

        // Test push
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test peek and pop
        System.out.println("Peek: " + stack.peek()); // Should print 3
        System.out.println("Pop: " + stack.pop());   // Should print 3

        // Test empty
        System.out.println("Is empty? " + stack.empty()); // Should print false

        // Test toString
        System.out.println("Stack: " + stack); // Should print the stack representation
    }
}
