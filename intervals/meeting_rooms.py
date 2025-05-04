# https://neetcode.io/problems/meeting-schedule

"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if len(intervals) ==0:
            return True
        intervals.sort(key=lambda i: i.start)
        lastEnd = intervals[0].end

        for i in intervals[1:]:
            if i.start < lastEnd:
                return False
            else:
                lastEnd = i.end
        return True
