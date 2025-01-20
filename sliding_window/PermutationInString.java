//https://leetcode.com/problems/permutation-in-string/description/

public class PermutationInString {
    /**
     * To check if whether there is a match we will use two arrays of size 26
     * We will have a match variable so that we don't have to iterate everytime to check if there is a match
     * If we find that a value at the same of both array matches we will increase the match count
     * Otherwise decrease it
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;

        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int i = s2.charAt(r) - 'a';
            s2Count[i]++;

            if (s2Count[i] == s1Count[i]) {
                matches++;
            } else if (s2Count[i] == s1Count[i] + 1) { //It could be possible that two values where same as we added another count it is no longer a match
                matches--; // In that case we would have to decreament the match count
            }

            i = s2.charAt(l) - 'a'; // To keep our window same simultaniousely we would have to increase l
            s2Count[i]--; // When we do that we also have to remove the count of that element

            if (s2Count[i] == s1Count[i]) {
                matches++;
            } else if (s2Count[i] == s1Count[i] - 1) { // It could happen that two elements were match at previous window but now that window has changed no longer matches
                matches--;
            }
            l++;
        }
        return matches == 26;


    }

}
