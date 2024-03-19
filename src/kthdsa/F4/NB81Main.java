package kthdsa.F4;

public class NB81Main {
    public static void main(String[] args) {
        // Skapa en kö med en initial storlek på 5
        NB81<Integer> queue = new NB81<>(5);

        // Testa 'offer' och 'poll' operationer
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
        }

        // Skriv ut elementen i kön
        System.out.println("Elements in the queue:");
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }

        // Testa gränsfall och felhantering
        System.out.println("\n\nTesting edge cases:");

        // Försök att ta bort från en tom kö
        System.out.println("Polling from an empty queue: " + queue.poll());

        // Försök att titta på en tom kö
        System.out.println("Peeking into an empty queue: " + queue.peek());

        // Försök att erbjuda fler element än maxstorleken
        for (int i = 1; i <= 7; i++) {
            queue.offer(i);
        }

        // Skriv ut elementen i kön efter överfyllnad
        System.out.println("\nElements in the queue after overflow:");
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
    }
}
