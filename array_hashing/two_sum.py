# https://leetcode.com/problems/two-sum/submissions/1451811686/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prev_map =  {}

        for i in range(len(nums)):
            diff = target - nums[i]

            if diff in prev_map:
                return (i,prev_map[diff])
            
            prev_map[nums[i]] = i
