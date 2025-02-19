# https://leetcode.com/problems/rotting-oranges/description/


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        q = deque()
        fresh = 0
        time = 0

        for r in range(R):
            for c in range(C):
                if grid[r][c] == 1:
                    fresh += 1
                elif grid[r][c] == 2:
                    q.append((r, c))

        while fresh > 0 and q:
            for i in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if nr >= 0 and nr < R and nc >= 0 and nc < C and grid[nr][nc] == 1:
                        fresh -= 1
                        grid[nr][nc] = 2
                        q.append((nr, nc))
            time += 1

        return -1 if fresh != 0 else time
