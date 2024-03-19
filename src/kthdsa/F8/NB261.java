package kthdsa.F8;

import java.util.HashMap;

public class NB261 {
    public static int mostCommonStringCount(String[] arr) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        int maxFrequency = 0;

        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(str));
        }

        return maxFrequency;
    }

    public static void main(String[] args) {
        String[] arr = {"man", "gråter", "när", "man", "tänker", "när"};
        System.out.println(mostCommonStringCount(arr)); // Output: 2
    }
}
