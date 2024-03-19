package kthdsa.F9;

import java.util.Arrays;

public class NB29a {
    private static void mergeSort(int[] a){
        if(a.length == 1) return;

        int[] b = new int[a.length/2];
        int[] c = new int[a.length - (a.length/2)];

        for(int i = 0; i < a.length/2; i++) b[i] = a[i];
        for(int i = a.length/2; i < a.length; i++) c[i-a.length/2] = a[i];

        mergeSort(b);
        mergeSort(c);

        merge(b,c,a);
    }

    private static void merge(int[] a, int[] b, int[] c){
        int indexA = 0, indexB = 0, indexC = 0;

        while(indexA < a.length && indexB < b.length){
            if(a[indexA] <= b[indexB]) c[indexC++] = a[indexA++];
            else c[indexC++] = b[indexB++];
        }

        while(indexA < a.length) c[indexC++] = a[indexA++];
        while(indexB < b.length) c[indexC++] = b[indexB++];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,6,9,8,72,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
