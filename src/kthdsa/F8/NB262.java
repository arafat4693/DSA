package kthdsa.F8;

import java.util.HashSet;

public class NB262 {
    public static int countUniqueStrings(String[] arr) {
        HashSet<String> uniqueStrings = new HashSet<>();

        for (String str : arr) {
            uniqueStrings.add(str);
        }

        return uniqueStrings.size();
    }

    public static void main(String[] args) {
        String[] arr = {"man", "gråter", "när", "man", "tänker", "när"};
        System.out.println(countUniqueStrings(arr)); // Output: 4
    }
}
