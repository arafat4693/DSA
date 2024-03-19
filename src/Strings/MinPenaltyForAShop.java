package Strings;

import java.util.Arrays;

public class MinPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int minPenalty = Integer.MAX_VALUE, hour = 0;
        int[] pre = new int[customers.length()+1];
        int[] post = new int[customers.length()+1];

        for(int i = 1; i <= customers.length(); i++){
            if(customers.charAt(i-1) == 'N') pre[i] = 1 + pre[i-1];
            else pre[i] = pre[i-1];
        }

        for(int i = customers.length()-1; i >= 0; i--){
            if(customers.charAt(i) == 'Y') post[i] = 1 + post[i+1];
            else post[i] = post[i+1];
        }

        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(post));

        for(int i = 0; i <= customers.length(); i++){
            if(pre[i] + post[i] < minPenalty){
                minPenalty = pre[i] + post[i];
                hour = i;
            }
        }

        return hour;
    }
}
