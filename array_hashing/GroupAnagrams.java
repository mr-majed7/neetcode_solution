//https://leetcode.com/problems/group-anagrams/description/

class Solution {
    /**
     * Create a HashMap where key will be count of each character seen
     * for each string calculate each characters occurance
     * keep strings with same character count in a list
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs){
            int[] count = new int[26];
            for (char c:s.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}