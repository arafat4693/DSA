package BitManipulation;

public class SumOf2Numbers {
    public int getSum(int a, int b) {
        while(true){
            int carry = (a & b) << 1;
            if(carry == 0) break;
            a = a ^ b;
            b = carry;
        }
        return a ^ b;
    }
}
