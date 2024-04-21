package DP;

import java.util.*;

public class MinNrOfDaysToEatNOranges {
    class State{
        int n;
        int days;

        public State(int n, int days){
            this.n = n;
            this.days = days;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State state)) return false;
            return n == state.n && days == state.days;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, days);
        }
    }

//    public int minDays(int n) {
//        Queue<State> heap = new LinkedList<>();
//        heap.add(new State(n, 0));
//
//        HashSet<State> visited = new HashSet<>();
//        visited.add(new State(n, 0));
//
//        while(!heap.isEmpty()){
//            State top = heap.poll();
//            if(top.n == 0) return top.days;
//
//            State minusOne = new State(top.n-1, top.days+1);
//            State divTwo = new State(top.n/2, top.days+1);
//            State divThree = new State(top.n - (2*(top.n/3)), top.days+1);
//
//            if(!visited.contains(minusOne)){
//                heap.add(minusOne);
//                visited.add(minusOne);
//            }
//
//            if(top.n % 2 == 0 && !visited.contains(divTwo)){
//                heap.add(divTwo);
//                visited.add(divTwo);
//            }
//
//            if(top.n % 3 == 0 && !visited.contains(divThree)){
//                heap.add(divThree);
//                visited.add(divThree);
//            }
//        }
//
//        return 0;
//    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public int minDays(int n){
        if(n == 1) return 1;
        if(n == 0) return 0;
        if(map.get(n) != null) return map.get(n);

        int ans = 1 + Math.min(n%2 + minDays(n/2), n%3 + minDays(n/3));
        map.put(n, ans);
        return ans;
    }
}
