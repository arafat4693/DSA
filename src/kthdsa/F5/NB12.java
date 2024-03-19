package kthdsa.F5;

public class NB12 {
    public static int power(int x, int n){
        if(n == 1) return x;
        return x * power(x, n-1);
    }

    public static int pow(int x, int n){
        int res = 1;
        for (int i = 1; i <= n; i++) res*=x;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 3));
    }
}
