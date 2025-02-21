# https://leetcode.com/problems/course-schedule/description/


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        prereq = {i: [] for i in range(numCourses)}

        for c, r in prerequisites:
            prereq[c].append(r)

        visited = set()

        def dfs(c):
            if c in visited:
                return False

            if prereq[c] == []:
                return True

            visited.add(c)

            for p in prereq[c]:
                if not dfs(p):
                    return False

            visited.remove(c)
            prereq[c] = []
            return True

        for c in range(numCourses):
            if not dfs(c):
                return False
        return True
