package kthdsa.F10;

import java.util.Arrays;

public class MinHeap<E extends Comparable<E>> {
    private E[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap(int initialCapacity) {
        heap = (E[]) new Comparable[initialCapacity];
        size = 0;
    }

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public void insert(E element) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = element;
        heapifyUp(size);
        size++;
    }

    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index].compareTo(heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public E extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        E min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < size && heap[leftChildIndex].compareTo(heap[smallest]) < 0) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[smallest]) < 0) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MinHeap<String> heap = new MinHeap<>();

        heap.insert("c");
        heap.insert("a");
        heap.insert("b");
        heap.insert("d");

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMin());
        }
    }
}

