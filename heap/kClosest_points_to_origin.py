# https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        min_heap = []

        for x,y in points:
            d = (x**2) + (y**2)
            min_heap.append([d,x,y])

        heapq.heapify(min_heap)

        res = []

        for i in range(k):
            d,x,y = heapq.heappop(min_heap)
            res.append([x,y])
        return res
