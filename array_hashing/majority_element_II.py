#https://leetcode.com/problems/majority-element-ii/

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        num1 = -1
        num2 = -1
        count1 = 0
        count2 = 0

        for n in nums:
            if n == num1:
                count1 +=1
            
            elif n == num2:
                count2 +=1
            elif count1 == 0:
                count1 = 1
                num1 = n
            elif count2 ==0:
                count2 = 1
                num2 = n
            else:
                count1 -=1
                count2 -=1
        
        count1 = 0
        count2 = 0

        for n in nums:
            if n == num1:
                count1 +=1
            elif n == num2:
                count2 +=1
            
        res = []
        n = len(nums)
        if count1 > n//3:
            res.append(num1)
        
        if count2 > n//3:
            res.append(num2)
        
        return res
            