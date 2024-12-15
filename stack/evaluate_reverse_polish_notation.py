# https://leetcode.com/problems/evaluate-reverse-polish-notation/description/


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for i in tokens:
            if i.isdigit() or (i.startswith('-') and i[1:].isdigit()):
                stack.append(int(i))
            else:
                n2 = stack.pop()
                n1 = stack.pop()
                if i == "+":
                    stack.append(n1 + n2)
                elif i == "-":
                    stack.append(n1 - n2)
                elif i == "*":
                    stack.append(n1 * n2)
                else:
                    stack.append(int(float(n1) / n2))
        return stack[-1]