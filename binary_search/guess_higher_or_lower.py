#https://leetcode.com/problems/guess-number-higher-or-lower/description/

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        l = 1
        r = n

        while True:
            m = (l+r)//2
            ans = guess(m)

            if ans == -1:
                r = m - 1
            elif ans == 1:
                l = m + 1
            else:
                return m