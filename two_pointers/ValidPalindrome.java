//https://leetcode.com/problems/valid-palindrome/

class Solution {
    /**
     * First initialize two pointer. One from start and another from the end
     * Increase l while l<r and character is not alphanumerical to escape non alphanumercial character
     * Do the same for R
     * Compare character at l and r position
     */
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while (l < r){
            while (l<r && !alphaNum(s.charAt(l))){
                l++;
            }
            while (r>l && !alphaNum(s.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}