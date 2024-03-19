package kthdsa.F9;

import java.util.Arrays;

public class NB29b {
    private static void shellSort(int[] arr){
        int gap = (arr.length)/2;

        while(gap > 0){
            for(int i = gap; i < arr.length; i++){
                int data = arr[i];
                int dataIndex = i;

                while(dataIndex > gap-1 && data < arr[dataIndex-gap]){
                    arr[dataIndex] = arr[dataIndex-gap];
                    dataIndex-=gap;
                }
                arr[dataIndex] = data;
            }
            if(gap == 2) gap = 1;
            else gap = gap/2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,6,9,8,72,4};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
