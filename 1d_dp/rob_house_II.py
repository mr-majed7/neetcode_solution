# https://leetcode.com/problems/house-robber-ii/description/


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        nums1 = nums[:-1]
        nums2 = nums[:0:-1]

        def dp(i, houses, cache):
            if i >= len(houses):
                return 0

            if cache[i] != -1:
                return cache[i]

            cache[i] = max(
                dp(i + 1, houses, cache), houses[i] + dp(i + 2, houses, cache)
            )
            return cache[i]

        return max(dp(0, nums1, [-1] * len(nums1)), dp(0, nums2, [-1] * len(nums2)))
