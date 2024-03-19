package ArrayAndHashing;

import java.util.*;

public class KFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        int[][] ans = new int[nums.length][2];
        ArrayList<Integer> result = new ArrayList<>();

        for(int n : nums){
            hashtable.put(n, hashtable.getOrDefault(n, 0) + 1);
        }

        Enumeration<Integer> it = hashtable.keys();

        int idx = 0;
        while(it.hasMoreElements()){
            int key = it.nextElement();
//            System.out.printf("%d,%d ", key, hashtable.get(key));
            ans[idx] = new int[]{key, hashtable.get(key)};
            idx++;
        }

        Arrays.sort(ans, (a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < k; i++){
            result.add(ans[i][0]);
        }

        // Convert the ArrayList back to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
