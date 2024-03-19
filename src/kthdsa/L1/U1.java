package kthdsa.L1;

public class U1 {
    public static void main(String[] args) {
        int r=0, n=100;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                for(int k=j;k<=i+j;k++)
                    for(int m=1;m<=i+j-k;m++)
                        r++;//Enkel sats
//            System.out.println("n: " + i);
//            System.out.println("r: " + r);
//            System.out.println();
            System.out.print(r + " ");
        }
    }
}
