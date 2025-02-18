# https://leetcode.com/problems/max-area-of-island/description/


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        R = len(grid)
        C = len(grid[0])

        maxArea = 0

        def bfs(r, c):
            q = deque()
            grid[r][c] = 0
            q.append([r, c])
            area = 1

            while q:
                m, n = q.popleft()
                for dm, dn in directions:
                    nm, nn = m + dm, n + dn
                    if nm < 0 or nn < 0 or nm >= R or nn >= C or grid[nm][nn] == 0:
                        continue
                    q.append([nm, nn])
                    grid[nm][nn] = 0
                    area += 1
            return area

        for r in range(R):
            for c in range(C):
                if grid[r][c] == 1:
                    maxArea = max(maxArea, bfs(r, c))

        return maxArea
