package Stacks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeed = new int[position.length][2];
        Stack<Double> st = new Stack<>();
        int carFleets = 0;

        for(int i = 0; i < position.length; i++){
            posSpeed[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(posSpeed, Comparator.comparingInt(a -> -a[0]));

//        for (int[] ints : posSpeed) {
//            double time = (double) (target - ints[0]) / ints[1];
//            if (st.empty()) st.push(time);
//            else if (st.peek() < time) {
//                carFleets++;
//                st.pop();
//                st.push(time);
//            }
//        }

        for(int[] ints : posSpeed){
            double time = (double) (target - ints[0]) / ints[1];
            st.push(time);
            if(st.size() >= 2 && st.peek() <= st.get(st.size()-2)) st.pop();
        }

//        return st.empty() ? carFleets : ++carFleets;
        return st.size();
    }
}
