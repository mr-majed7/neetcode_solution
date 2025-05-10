#https://leetcode.com/problems/baseball-game/

class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack, res = [], 0
        for o in operations:
            if o == "+":
                res += stack[-1] + stack[-2]
                stack.append(stack[-1] + stack[-2])
            elif o == "D":
                res += (2 * stack[-1])
                stack.append(2 * stack[-1])
            elif o == "C":
                res -= stack.pop()
            else:
                res += int(o)
                stack.append(int(o))
        return res
