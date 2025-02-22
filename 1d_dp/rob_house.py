#https://leetcode.com/problems/house-robber/description/

class Solution:
    def rob(self, nums: List[int]) -> int:
        self.nums = nums
        cache = [-1] * len(nums)
        def dp(i):
            if i >= len(self.nums):
                return 0
            if cache[-1] != -1:
                return cache[i]
            cache[i] = max(dp(i+1),self.nums[i]+dp(i+2))
            return cache[i]
        
        return dp(0)
