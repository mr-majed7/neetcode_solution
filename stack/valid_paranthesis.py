# https://leetcode.com/problems/valid-parentheses/


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        paranthesiss = {")": "(", "]": "[", "}": "{"}

        for c in s:
            if c in paranthesiss:
                if stack and stack[-1] == paranthesiss[c]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)

        return True if not stack else False
