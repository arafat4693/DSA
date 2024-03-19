package kthdsa.F5;

public class NB11 {
    public static int maxValue(int[] arr){
        if(arr.length == 1) return arr[0];
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 1, newArr, 0, arr.length - 1);
        return Math.max(arr[0], maxValue(newArr));
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{1, 2, 9, 3, 46}));
    }
}
