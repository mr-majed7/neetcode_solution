//https://leetcode.com/problems/two-sum/description/

class Solution {
    /**
     * Have a hashmap that will store all the number iterated and the're corresponding index
     * For each number calculate the difference from target
     * If the difference is in the hashamp return index of two values
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> prevMap = new HashMap<>();

        for (int i=0 ; i<nums.length ; i++){
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)){
                return new int[] {prevMap.get(diff),i};
            }
            prevMap.put(num,i);
        }
        return new int[] {};
    }
}