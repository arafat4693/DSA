package kthdsa.F3;

public class NB7Main {
    public static void main(String[] args) {
        NB7<Integer> stack = new NB7<>();

        // Test push
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test size
        System.out.println("Size: " + stack.size()); // Should print 3

        // Test peek(n)
        System.out.println("Peek(0): " + stack.peek(0)); // Should print 3
        System.out.println("Peek(1): " + stack.peek(1)); // Should print 2
        System.out.println("Peek(2): " + stack.peek(2)); // Should print 1

        // Test flush
        System.out.println("Flush: " + stack.flush()); // Should print 3
        System.out.println("Is empty? " + stack.empty()); // Should print true
    }
}
