package ArrayAndHashing;

import java.util.Arrays;

public class EliminateMaxNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] times = new double[dist.length];

        for(int i = 0; i < dist.length; i++){
            times[i] = (double) dist[i] /speed[i];
        }

        Arrays.sort(times);

        int time = 1, count = 1;

        for(int i = 1; i < dist.length; i++){
            if(times[i] - time <= 0) break;
            count++;
            time++;
        }

        return count;
    }
}
