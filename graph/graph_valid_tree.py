# https://neetcode.io/problems/valid-tree


class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) > n - 1:
            return False

        graph = [[] for i in range(n)]

        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        visited = set()

        def dfs(node, prev):
            if node in visited:
                return False

            visited.add(node)

            for n in graph[node]:
                if n == prev:
                    continue
                if not dfs(n, node):
                    return False
            return True

        return dfs(0, -1) and len(visited) == n
