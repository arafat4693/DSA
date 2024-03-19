package kthdsa.F5;

public class NB13 {
    public static double rot(double n, double a, double e){
        if(Math.abs(Math.pow(a, 2) - n) < e) return a;
        return rot(n, (Math.pow(a, 2) + n)/(2*a), e);
    }

    public static void main(String[] args) {
        System.out.printf("%.3f", rot(16, 1, 3));
    }
}
