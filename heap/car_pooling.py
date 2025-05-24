#https://leetcode.com/problems/car-pooling/description/

class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key=lambda t: t[1])

        heap = []
        curr = 0

        for numPass, s, e in trips:
            while heap and heap[0][0] <= s:
                curr -= heapq.heappop(heap)[1]
            
            curr += numPass

            if curr > capacity:
                return False
            heapq.heappush(heap,[e,numPass])
        return True