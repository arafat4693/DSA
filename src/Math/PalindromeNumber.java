package Math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int reversed = 0;
        int r = x;

        while(r > 0){
            reversed = reversed * 10 + (r % 10);
            r /= 10;
        }

        return reversed == x;
    }
}
