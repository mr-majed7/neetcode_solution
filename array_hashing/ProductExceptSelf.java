//https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    /**
     *We can calculate the product except self why multipying the prefix product and postfix product
     * We can have two separate arrays; in one we will have the postfix product and in another prefix product
     * To optimize space complexity one single array can be used
     * In that array first we will calculate the prefix. For every position it's prefix product will at i-1
     * First we will initialize the start position as the value of 0 index as first element do not have any prefix
     * After that in every position of array we will multiply it with the i-1 value of nums array with i-1 value of prefix result array
     * This is because we will need to find the Prefix
     * After that we will initilize postfix at 1
     * Then we will multiply with the prefix value.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;

        for (int i = 1; i < n; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int postfix = 1;

        for (int i = n-1; i>=0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}