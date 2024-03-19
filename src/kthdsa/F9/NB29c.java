package kthdsa.F9;

import java.util.Arrays;

public class NB29c {
    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private static int partition(int low, int high, int[] arr){
        int pivot = arr[high];
        int p = low;

        for(int i = low; i < high; i++){
            if(arr[i] <= pivot){
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, p, high);
        return p;
    }

    private static void quickSort(int low, int high, int[] arr){
        if(low < high){
            int p = partition(low, high, arr);
            quickSort(0, p-1, arr);
            quickSort(p+1, high, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,6,9,8,72,4};
        quickSort(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }
}
