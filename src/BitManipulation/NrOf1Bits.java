package BitManipulation;

public class NrOf1Bits {
    public int hammingWeight(int n) {
//        String bin = Integer.toBinaryString(n);
//        int c = 0;
//        for(int i = 0; i < bin.length(); i++) {
//            if(bin.charAt(i) == '1') c++;
//        }
//        return c;

//        int res = 0;
//        while(n > 0){
//            res += (n & 1);
//            n = n >>> 1;
//        }
//        return res;

        int res = 0;
        while(n != 0){
            n = n & (n-1); // get rids of 1 from the right side
            res++;
        }
        return res;
    }
}
