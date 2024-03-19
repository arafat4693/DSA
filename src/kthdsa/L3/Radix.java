package kthdsa.L3;

import java.util.Arrays;

public class Radix {
    private int[] arr;
    public Radix(int[] arr){
        this.arr = arr;
    }
    public void radixSort(){
        int maxElm = getMax();
        int exp = 1;
        while(maxElm / exp > 0) {
            countingSort(exp);
            exp *= 10;
        }
    }
    private void countingSort(int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int j : arr) count[(j / exp) % 10]++; //Frequency

        for(int i = 1; i < 10; i++) count[i] += count[i-1]; //sum

        for(int i = n-1; i >= 0; i--) {
            count[(arr[i] / exp) % 10]--;
            output[count[(arr[i] / exp) % 10]] = arr[i];
        }

        System.arraycopy(output, 0, arr, 0, n);
//        System.out.println("Counting sort at exp " + exp + " " + Arrays.toString(arr));
    }

    private int getMax() {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    public boolean IsSorted(){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
