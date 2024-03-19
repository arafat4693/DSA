package kthdsa.L3;

import java.util.Random;

public class RadixSortMain {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] arr = new int[1_000_000];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = rand.nextInt(1_000_000);
        }

        int[] arr2 = new int[]{3, 5, 1, 4, 6, 2, 9};

        long start = System.currentTimeMillis();
        Radix sort = new Radix(arr);
        sort.radixSort();
        System.out.println(sort.IsSorted());
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Time is " + time + " ms");
    }
}
