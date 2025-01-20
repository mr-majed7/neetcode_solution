//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuySellStock {
    /**
     * Simple Sliding window method can be used to solve this
     * We will take two pointer
     * The front pointer will be used to iterate the array
     * If the buying price is greater than the selling price that means at that window we have found the maximum possible profit
     * So we will consider that finished and work with later parts
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r;
            } else {
                profit = Math.max(profit, prices[r] - prices[l]);
            }
            r++;

        }
        return profit;

    }
}
