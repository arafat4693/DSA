package kthdsa.F4;

public class NB9Main {
        public static void main(String[] args) {
            NB9<Integer> queue = new NB9<>();

            // Enqueue elements
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            // Print size
            System.out.println("Size of the queue: " + queue.size());

            // Dequeue elements
            System.out.println("Dequeued element: " + queue.dequeue());
            System.out.println("Dequeued element: " + queue.dequeue());

            // Print size after dequeue
            System.out.println("Size of the queue: " + queue.size());
        }
}
