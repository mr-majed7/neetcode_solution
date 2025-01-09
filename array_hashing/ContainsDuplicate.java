//https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> seen = new HashSet<>(); //Create a set to store seen elements
        for (int num: nums){
            if (seen.contains(num)){ // if seen elements are in seen return true
                return true;
            }
            seen.add(num);
        }
        return false;//if no element was seen twice return false
    }
}