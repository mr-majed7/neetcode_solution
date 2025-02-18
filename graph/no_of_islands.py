# https://leetcode.com/problems/number-of-islands/description/


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        R = len(grid)
        C = len(grid[0])

        res = 0

        def bfs(r, c):
            q = deque()
            grid[r][c] = "0"
            q.append([r, c])

            while q:
                m, n = q.popleft()
                for dm, dn in directions:
                    nm, nn = m + dm, n + dn
                    if nm < 0 or nn < 0 or nm >= R or nn >= C or grid[nm][nn] == "0":
                        continue
                    q.append([nm, nn])
                    grid[nm][nn] = "0"

        for r in range(R):
            for c in range(C):
                if grid[r][c] == "1":
                    bfs(r, c)
                    res += 1
        return res
