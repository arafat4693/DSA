package BinarySearch;

import java.util.*;

class Pair {
    int timeStamp;
    String str;
    public Pair (int timeStamp, String str) {
        this.timeStamp = timeStamp;
        this.str = str;
    }
}

public class TimeMap {
    private final HashMap<String, ArrayList<Pair>> kvStore;
    public TimeMap() {
        this.kvStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!kvStore.containsKey(key)) {
            kvStore.put(key, new ArrayList<>());
        }

        Pair pair = new Pair(timestamp, value); // Storing a pair in the map for that given key
        kvStore.get(key).add(pair);
    }

    public String get(String key, int timestamp) {
        ArrayList<Pair> data = kvStore.get(key);

        if (data == null) {
            return "";  // or handle the case where the key is not present
        }

        int low = 0;
        int high = data.size() - 1;

        while (low <= high){
            int mid = (low + high)/2;
            if(data.get(mid).timeStamp == timestamp) return data.get(mid).str;
            if(data.get(mid).timeStamp < timestamp) low = mid + 1;
            else high = mid - 1;
        }

        return high != -1 ? data.get(high).str : "";
    }
}
