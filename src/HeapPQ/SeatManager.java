package HeapPQ;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SeatManager {
    private PriorityQueue<Integer> seats;

    public SeatManager(int n) {
        seats = new PriorityQueue<>((a, b) -> a-b);
        for(int i = 1; i <= n; i++) seats.add(i);
    }

    public int reserve() {
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}
