package BitManipulation;

public class CountTripletsXOR {
//    public int countTriplets(int[] arr) {
//        int res = 0;
//
//        for(int i = 0; i < arr.length-1; i++){
//            int a = 0;
//            for(int j = i+1; j < arr.length; j++){
//                a ^= arr[j-1];
//                int b = 0;
//                for(int k = j; k < arr.length; k++){
//                    b ^= arr[k];
//                    if(a == b) res++;
//                }
//            }
//        }
//
//        return res;
//    }

    public int countTriplets(int[] arr) {
        int res = 0;

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] ^ arr[i];
        }

        for(int i = 0; i < arr.length-1; i++){
            int remove = i-1 < 0 ? 0 : prefix[i-1];
            for(int j = i+1; j < arr.length; j++){
                if((prefix[j] ^ remove) == 0) res += (1 + (j-i-1));
            }
        }

        return res;
    }
}
