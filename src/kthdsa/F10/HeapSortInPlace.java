package kthdsa.F10;

public class HeapSortInPlace {
    public static void heapSort(int[] array) {
        int n = array.length;
        int m = 1;

        // Bygg upp max-heapen
        while (m < n) {
            offer(array, m++);
        }

        // Sortera arrayen
        while (m > 1) {
            array[m - 1] = poll(array, m--);
        }
    }

    // Metod för att sätta in ett element i heapen
    private static void offer(int[] array, int m) {
        int index = m - 1;
        int parentIndex = (index - 1) / 2;

        while (index > 0 && array[parentIndex] < array[index]) {    // {12, 11, 13, 5, 6, 7}
            swap(array, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Metod för att ta bort och returnera det största elementet i heapen
    private static int poll(int[] array, int m) {
        int max = array[0];
        array[0] = array[m - 1];

        int index = 0;
        int leftChildIndex, rightChildIndex;

        while (true) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;

            int maxIndex = index;

            if (leftChildIndex < m - 1 && array[leftChildIndex] > array[maxIndex]) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < m - 1 && array[rightChildIndex] > array[maxIndex]) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == index) {
                break;
            }

            swap(array, index, maxIndex);
            index = maxIndex;
        }

        return max;
    }

    // Metod för att byta plats på två element i arrayen
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Array innan sortering:");
        printArray(array);

        heapSort(array);

        System.out.println("Array efter sortering:");
        printArray(array);
    }

    // Metod för att skriva ut en array
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

