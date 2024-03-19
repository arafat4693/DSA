package HeapPQ;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size() - minHeap.size() == 2) minHeap.add(maxHeap.poll());
        else if(minHeap.size() - maxHeap.size() == 2) maxHeap.add(minHeap.poll());

        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) minHeap.add(maxHeap.poll());
        if(maxHeap.size() - minHeap.size() == 2) minHeap.add(maxHeap.poll());
        else if(minHeap.size() - maxHeap.size() == 2) maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) return (double) ((minHeap.isEmpty() ? 0 : minHeap.peek()) + (minHeap.isEmpty() ? 0 : maxHeap.peek()))/2;
        else return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
}
