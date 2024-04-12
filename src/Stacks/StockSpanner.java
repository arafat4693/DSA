package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
//    private List<Integer> stocks;
//    public StockSpanner() {
//        this.stocks = new ArrayList<>();
//    }
//
//    public int next(int price) {
//        stocks.add(price);
//        int cnt = 0;
//
//        for(int i = stocks.size()-1; i >= 0; i--){
//            if(stocks.get(i) > price) break;
//            cnt++;
//        }
//
//        return cnt;
//    }

    private Stack<int[]> mono = new Stack<>();
    public StockSpanner() {
        this.mono = new Stack<>();
    }

    public int next(int price) {
        int cnt = 1;

        while(!mono.isEmpty() && mono.peek()[0] <= price){
            cnt += mono.pop()[1];
        }

        mono.add(new int[]{price, cnt});
        return cnt;
    }
}
