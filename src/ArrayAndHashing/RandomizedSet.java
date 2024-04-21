package ArrayAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> arr;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int valIndex = map.get(val);
        int tmp = arr.get(arr.size()-1);
        arr.set(arr.size()-1, val);
        arr.set(valIndex, tmp);
        arr.remove(arr.size()-1);
        map.put(tmp, valIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(arr.size());
        return arr.get(index);
    }
}
