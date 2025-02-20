# https://leetcode.com/problems/course-schedule-ii/description/


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        prereq = {i: [] for i in range(numCourses)}
        for c, p in prerequisites:
            prereq[c].append(p)

        output = []
        visited = set()
        cycle = set()

        def dfs(c):
            if c in cycle:
                return False
            if c in visited:
                return True

            cycle.add(c)
            for p in prereq[c]:
                if dfs(p) == False:
                    return False
            cycle.remove(c)
            visited.add(c)
            output.append(c)
            return True

        for c in range(numCourses):
            if dfs(c) == False:
                return []
        return output
