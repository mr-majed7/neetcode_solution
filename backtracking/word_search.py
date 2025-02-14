# https://leetcode.com/problems/word-search/description/


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row = len(board)
        col = len(board[0])

        path = set()

        def backtrack(r, c, i):
            if i == len(word):
                return True

            if (
                r < 0
                or r >= row
                or c < 0
                or c >= col
                or word[i] != board[r][c]
                or (r, c) in path
            ):
                return False

            path.add((r, c))

            res = (
                backtrack(r + 1, c, i + 1)
                or backtrack(r - 1, c, i + 1)
                or backtrack(r, c + 1, i + 1)
                or backtrack(r, c - 1, i + 1)
            )
            path.remove((r, c))
            return res

        for r in range(row):
            for c in range(col):
                if backtrack(r, c, 0):
                    return True
        return False
