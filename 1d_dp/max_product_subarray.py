# https://leetcode.com/problems/maximum-product-subarray/description/


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]

        currMax = 1
        currMin = 1

        for n in nums:
            temp = currMax * n
            currMax = max(n * currMax, n * currMin, n)
            currMin = min(temp, n * currMin, n)
            res = max(currMax, res)

        return res
