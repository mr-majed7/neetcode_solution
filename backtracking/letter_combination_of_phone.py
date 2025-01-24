# https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        num_to_lett = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "qprs",
            "8": "tuv",
            "9": "wxyz",
        }

        def backtrack(i, currStr):
            if len(currStr) == len(digits):
                res.append(currStr)
                return

            for c in num_to_lett[digits[i]]:
                backtrack(i + 1, currStr + c)

        if digits:
            backtrack(0, "")
        return res
