package SlidingWindow;

public class BestBuySellStock {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;

        while(right < prices.length){
            if(prices[right] - prices[left] <= 0){
                left = right;
            }else{
                profit = Math.max(profit, prices[right] - prices[left]);
            }
            right++;
        }

        return profit;
    }
}
