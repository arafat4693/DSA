package HeapPQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MInCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[][] ratio = new double[quality.length][2];
        for(int i = 0; i < quality.length; i++) ratio[i] = new double[]{quality[i], (double) wage[i] /quality[i]};
        Arrays.sort(ratio, (a, b) -> Double.compare(a[1], b[1]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> (int) (b - a));
        double res = Double.MAX_VALUE, qualities = 0;

        for(int i = 0; i < ratio.length; i++){
            maxHeap.add(ratio[i][0]);
            qualities += ratio[i][0];
            if(maxHeap.size() == k) {
                res = Math.min(res, qualities*ratio[i][1]);
                qualities -= maxHeap.poll();
            }
        }

        return res;
    }
}
