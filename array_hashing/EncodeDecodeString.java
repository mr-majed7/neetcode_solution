//https://neetcode.io/problems/string-encode-and-decode

class Solution {
    /**
     * We will encode with length of the string + # + string
     */
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String s: strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();

    }

    /**
     * First get the length. The length will be the integer value upuntill #
     * After the # to the length is a string
     */
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
