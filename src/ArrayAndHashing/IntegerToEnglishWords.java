package ArrayAndHashing;

import java.util.HashMap;

public class IntegerToEnglishWords {
    HashMap<Integer, String> nums = new HashMap<>();

    private void fillMap() {
        nums.put(0, "Zero");
        nums.put(1, "One");
        nums.put(2, "Two");
        nums.put(3, "Three");
        nums.put(4, "Four");
        nums.put(5, "Five");
        nums.put(6, "Six");
        nums.put(7, "Seven");
        nums.put(8, "Eight");
        nums.put(9, "Nine");
        nums.put(10, "Ten");
        nums.put(11, "Eleven");
        nums.put(12, "Twelve");
        nums.put(13, "Thirteen");
        nums.put(14, "Fourteen");
        nums.put(15, "Fifteen");
        nums.put(16, "Sixteen");
        nums.put(17, "Seventeen");
        nums.put(18, "Eighteen");
        nums.put(19, "Nineteen");
        nums.put(20, "Twenty");
        nums.put(30, "Thirtee");
        nums.put(40, "Fourty");
        nums.put(50, "Fifty");
        nums.put(60, "Sixty");
        nums.put(70, "Seventy");
        nums.put(80, "Eighty");
        nums.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        fillMap();
        return solve(num);
    }

    private String solve(int num) {
        if(num == 0) return "Zero";
        if(nums.containsKey(num)) return nums.get(num);

        int d = 0;
        String mid = "";

        if(num < 100) {
            d = 10;
        }
        else if(num < 1000) {
            d = 100;
            mid = "Hundred";
        }
        else if(num < 1000000) {
            d = 1000;
            mid = "Thousand";
        }
        else if(num < 1000000000) {
            d = 1000000;
            mid = "Million";
        }
        else {
            d = 1000000000;
            mid = "Billion";
        }

        StringBuilder res = new StringBuilder();

        if(d == 10) res.append(nums.get((num/d)*d));
        else res.append(solve(num / d)).append(" ").append(mid);

        if((num % d) != 0) res.append(" ").append(solve(num % d));

        return res.toString();
    }
}
