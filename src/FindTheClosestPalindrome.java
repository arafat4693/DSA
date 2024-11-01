import java.util.ArrayList;
import java.util.List;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int N = n.length();
        int mid = N%2 == 0 ? N/2 : N/2 + 1;

        long firstHalf = Long.parseLong(n.substring(0, mid));

        List<Long> possibleAnswers = new ArrayList<>();

        possibleAnswers.add(getPali(firstHalf, N%2 == 0));
        possibleAnswers.add(getPali(firstHalf+1, N%2 == 0));
        possibleAnswers.add(getPali(firstHalf-1, N%2 == 0));
        possibleAnswers.add((long)Math.pow(10, N) + 1);
        possibleAnswers.add((long)Math.pow(10, N-1) - 1);

        // System.out.println(possibleAnswers);

        Long original = Long.parseLong(n);
        Long result = original;
        Long diff = Long.MAX_VALUE;

        for(long ans : possibleAnswers) {
            if(ans == original) continue;

            Long d = Math.abs(ans - original);

            System.out.println(diff);
            System.out.println(d);
            System.out.println(ans);
            System.out.println();

            if(diff > d) {
                diff = d;
                result = ans;
            }else if(diff.equals(d)) {
                System.out.println("IN");
                result = Math.min(result, ans);
            }

            // System.out.println(result);
        }

        return String.valueOf(result);
    }

    private long getPali(long firstHalf, boolean even) {
        long result = firstHalf;

        if(!even) firstHalf /= 10;

        while(firstHalf > 0) {
            result = (result * 10) + (firstHalf % 10);
            firstHalf /= 10;
        }

        return result;
    }
}
