package kthdsa.F4;

public class NB8Main {
    public static void main(String[] args) {
        // Create an NB8 object with a maximum size of 5
        NB8<Integer> nb8Queue = new NB8<>(5);

        // Test offer method
        for (int i = 1; i <= 7; i++) {
            nb8Queue.offer(i);
            System.out.println("After offering " + i + ": " + nb8Queue);
        }

        // Test peek method
        System.out.println("Peek: " + nb8Queue.peek());

        // Test poll method
        for (int i = 1; i <= 4; i++) {
            System.out.println("Polled: " + nb8Queue.poll());
            System.out.println("After polling: " + nb8Queue);
        }
    }
}
