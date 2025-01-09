# https://neetcode.io/problems/string-encode-and-decode


class Solution:

    def encode(self, strs: List[str]) -> str:
        enc_str = ""

        for s in strs:
            enc_str += str(len(s)) + "$" + s
        return enc_str

    def decode(self, s: str) -> List[str]:
        dec_strs = []

        i = 0

        while i < len(s):
            j = i

            while s[j] != "$":
                j += 1

            length = int(s[i:j])
            dec_strs.append(s[j + 1 : j + 1 + length])
            i = j + 1 + length
        return dec_strs
