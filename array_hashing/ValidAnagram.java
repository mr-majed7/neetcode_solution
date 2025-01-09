//https://leetcode.com/problems/valid-anagram/

class Solution {
    /**
     * Have two hashmaps for two strings
     * For each characters in the both strings calcuate their counts
     * If the counts are same they are anagram
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i=0 ; i<s.length() ; i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i),0) + 1);
        }

        return countS.equals(countT);
    }
}