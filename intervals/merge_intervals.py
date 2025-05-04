# https://leetcode.com/problems/merge-intervals/

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda pair: pair[0])

        output = [intervals[0]]

        for s, e in intervals:
            lastEnd = output[-1][1]

            if s <= lastEnd:
                output[-1][1] = max(lastEnd, e)
            else:
                output.append([s,e])
        return output
