package kthdsa.F9;

import java.util.Arrays;

public class NB28 {
    private static void urvalssort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void instickssort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int data = arr[i];
            int dataIdx = i;

            while(dataIdx > 0 && arr[dataIdx] < arr[dataIdx-1]) {
                arr[dataIdx] = arr[dataIdx-1];
                arr[dataIdx-1] = data;
                dataIdx--;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,6,9,8,72,4};
//        urvalssort(arr);
        instickssort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
