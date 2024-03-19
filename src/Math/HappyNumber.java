package Math;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();

        while(n != 1){
            if(visited.add(n)){
                int sum = 0;
                int curr = n;
                while (curr > 0) {
                    int digit = curr % 10; // Extract the last digit
                    sum += digit*digit;
                    curr = curr / 10; // Remove the last digit
                }
                n = sum;
            }else return false;
        }

        return true;
    }
}
