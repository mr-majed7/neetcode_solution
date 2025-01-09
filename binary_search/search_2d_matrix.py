# https://leetcode.com/problems/search-a-2d-matrix/description/


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])

        t = 0
        b = rows - 1

        while t <= b:
            m = (b + t) // 2

            if target > matrix[m][-1]:
                t = m + 1

            elif target < matrix[m][0]:
                b = m - 1

            else:
                break

        if not (t <= b):
            return False

        row = (t + b) // 2
        l = 0
        r = cols - 1
        while l <= r:
            m = (l + r) // 2
            if target > matrix[row][m]:
                l = m + 1
            elif target < matrix[row][m]:
                r = m - 1
            else:
                return True
        return False
