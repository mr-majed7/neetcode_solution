# https://leetcode.com/problems/walls-and-gates/description/


# BFS
class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        R = len(grid)
        C = len(grid[0])

        def bfs(r, c):
            q = deque()
            q.append([r, c])
            visited = [[False] * C for _ in range(R)]
            visited[r][c] = True
            d = 0

            while q:
                for n in range(len(q)):
                    row, col = q.popleft()
                    if grid[row][col] == 0:
                        return d
                    for dr, dc in directions:
                        nr, nc = row + dr, col + dc
                        if (
                            0 <= nr < R
                            and 0 <= nc < C
                            and not visited[nr][nc]
                            and grid[nr][nc] != -1
                        ):
                            visited[nr][nc] = True
                            q.append([nr, nc])
                d += 1

        for r in range(R):
            for c in range(C):
                if grid[r][c] == -1 or grid[r][c] == 0:
                    continue
                else:
                    distance = bfs(r, c)
                    if distance != 0:
                        grid[r][c] = distance


# MULTI SOURCE BFS
class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        R = len(grid)
        C = len(grid[0])
        visited = set()
        q = deque()

        def addCell(r, c):
            if (
                min(r, c) < 0
                or r == R
                or c == C
                or (r, c) in visited
                or grid[r][c] == -1
            ):
                return
            visited.add((r, c))
            q.append((r, c))

        for r in range(R):
            for c in range(C):
                if grid[r][c] == 0:
                    q.append((r, c))
                    visited.add((r, c))

        distance = 0
        while q:
            for i in range(len(q)):
                r, c = q.popleft()
                grid[r][c] = distance
                addCell(r + 1, c)
                addCell(r - 1, c)
                addCell(r, c + 1)
                addCell(r, c - 1)
            distance += 1
