# https://leetcode.com/problems/clone-graph/description/


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:
        copyGraph = {}

        def dfs(node):
            if node in copyGraph:
                return copyGraph[node]

            copy = Node(node.val)
            copyGraph[node] = copy

            for n in node.neighbors:
                copy.neighbors.append(dfs(n))
            return copy

        return dfs(node) if node else None
