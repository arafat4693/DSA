package kthdsa.F4;

public class NB10Main {
    public static void main(String[] args) {
        NB10<Integer> deque = new NB10();

        // Offer elements at the front and rear
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.offerFirst(5);

        // Poll elements from the front and rear
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());

        // Check if the deque is empty
        System.out.println("Is Empty: " + deque.empty());
    }
}