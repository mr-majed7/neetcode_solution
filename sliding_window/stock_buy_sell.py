# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0

        l = 0
        r = 1

        while r < len(prices):
            if prices[l] < prices[r]:
                profit = max(profit, prices[r] - prices[l])

            else:
                l = r
            r += 1
        return profit
