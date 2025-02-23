# https://leetcode.com/problems/palindromic-substrings/description/


def countSubstrings(self, s: str) -> int:
    res = 0

    for i in range(len(s)):
        l = i
        r = i

        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
            res += 1

        l = i
        r = i + 1

        while l >= 0 and r < len(s) and s[l] == s[r]:
            res += 1
            l -= 1
            r += 1
    return res
