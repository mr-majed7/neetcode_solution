//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

public class TwoSumII {
    /**
     * Use two pointers approach
     * If current sum is greater than target decrease r
     * If current sum is less than target increase l
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while (l<r){
            int cur = numbers[l] + numbers[r];

            if (cur < target){
                l++;
            }else if (cur>target){
                r--;
            }else{
                return new int[] {l+1,r+1};
            }
        }
        return new int[0];

    }
}
