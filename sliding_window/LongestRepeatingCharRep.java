//https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestRepeatingCharRep {
    /**
     * Here we would have a hashmap where we will keep the count of character
     * We will check if current length of the string - max frequency of max character is greater than k
     * If it is we need to shrink the string
     * We can do this by increasing l
     */
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;

        int l = 0;
        int maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
