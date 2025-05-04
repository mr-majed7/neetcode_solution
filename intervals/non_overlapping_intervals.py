# https://leetcode.com/problems/non-overlapping-intervals/

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()

        res = 0
        lastEnd = intervals[0][1]

        for s,e in intervals[1:]:
            if s>=lastEnd:
                lastEnd = e
            else:
                res +=1
                lastEnd = min(lastEnd,e)
        return res
