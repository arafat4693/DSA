package Math;

public class CountAllValidPickupDelivery {
    public int countOrders(int n) {
        long res = 1;
        int mod = (int) Math.pow(10, 9) + 7;

        for(int i = 2*n; i > 0; i-=2){
            res *= (((long) i *(i-1))/2);
            res %= mod;
        }

        return (int)res;
    }
}
