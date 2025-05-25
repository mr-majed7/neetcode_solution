#https://leetcode.com/problems/island-perimeter/description/

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        visit = set()

        def dfs(r,c):
            if r >= rows or c >= cols or r < 0 or c < 0 or grid[r][c] == 0:
                return 1
            
            if (r,c) in visit:
                return 0
            
            visit.add((r,c))
            perim = dfs(r,c+1)+dfs(r+1,c)+dfs(r,c-1)+dfs(r-1,c)
            return perim
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c]:
                    return dfs(r,c)
        return 0