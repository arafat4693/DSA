package ArrayAndHashing;

import java.util.HashMap;

public class NrOfParisInterchangeableRects {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> freq = new HashMap<>();
        long total = 0;

        for(int[] rect : rectangles) freq.put((double) rect[0]/rect[1], freq.getOrDefault((double)rect[0]/rect[1], 0)+1);

        for(int i = 0; i < rectangles.length; i++){
            double ratio = (double)rectangles[i][0] / rectangles[i][1];
            if(freq.get(ratio) == 1) continue;
            freq.put(ratio, freq.get(ratio)-1);
            total += freq.get(ratio);
        }

        return total;
    }
}
