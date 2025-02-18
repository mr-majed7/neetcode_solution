# https://leetcode.com/problems/task-scheduler/


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counts = Counter(tasks)
        max_heap = [-c for c in counts.values()]
        heapq.heapify(max_heap)

        t = 0
        queue = deque()

        while max_heap or queue:
            t += 1

            if not max_heap:
                t = queue[0][1]
            else:
                count = 1 + heapq.heappop(max_heap)
                if count:
                    queue.append([count, t + n])
            if queue and queue[0][1] == t:
                heapq.heappush(max_heap, queue.popleft()[0])
        return t
