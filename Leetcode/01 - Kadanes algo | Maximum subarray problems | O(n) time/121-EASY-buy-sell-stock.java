//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://www.youtube.com/watch?v=3RHCb8LY-X4
class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length==0) return 0;
        
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i=0; i<prices.length; i++) {
            int cur = prices[i];
            int curProfit = prices[i] - minVal;
            
            // Update min value
            if (cur < minVal) {
                minVal = cur;
            } else if (curProfit > maxProfit) { // Check maxProfit
                maxProfit = curProfit;
            }
        }
        
        return maxProfit;
    }
}