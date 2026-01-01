class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy_price = prices[0];
        int max_profit = 0;
        for(int i=0;i<n;i++){
            int curr_profit = prices[i]-buy_price ;
        if(curr_profit > max_profit){
            max_profit=curr_profit;
        }
        if(prices[i]<buy_price){
            buy_price = prices[i];
        }
        }
        return max_profit;
    }
}