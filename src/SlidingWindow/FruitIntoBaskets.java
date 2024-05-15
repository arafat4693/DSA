package SlidingWindow;

import java.util.HashSet;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int res = 0;
        HashSet<Integer> baskets = new HashSet<>();

        int l = 0;
        for(int r = 0; r < fruits.length; r++){
            if(baskets.size() < 2){
                baskets.add(fruits[r]);
                continue;
            }

            if(!baskets.contains(fruits[r])){
                res = Math.max(res, r-l);
                baskets.clear();
                baskets.add(fruits[r]);
                baskets.add(fruits[r-1]);

                l = r-1;
                while(l-1 >= 0 && fruits[l-1] == fruits[r-1]) l--;
            }
        }

        res = Math.max(res, fruits.length-l);

        return res;
    }
}
