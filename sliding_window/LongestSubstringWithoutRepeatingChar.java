//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {
    /**
     * A set will be maintained to keep track of unique characters
     * We will use sliding window here also
     * As long as our current character is in the set we will increase l to minimize the window and remove that character
     * from the set
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int r = 0;
        int res = 0;

        while (r < s.length()) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
