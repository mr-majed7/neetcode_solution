# https://leetcode.com/problems/generate-parentheses/


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        res = []

        def addParenthesis(openC, closeC):
            if openC == closeC == n:
                res.append("".join(stack))
                return

            if openC < n:
                stack.append("(")
                addParenthesis(openC + 1, closeC)
                stack.pop()

            if closeC < openC:
                stack.append(")")
                addParenthesis(openC, closeC + 1)
                stack.pop()

        addParenthesis(0, 0)
        return res
