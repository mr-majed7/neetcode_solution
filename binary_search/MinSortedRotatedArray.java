//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class MinSortedRotatedArray {
    /**
     * Here we need to figure out is that rotated portion
     * If our middle is greater than left most value at that point that means our result is in the right portion
     * If it is not then minimum value is in the left portion
     */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l<=r){
            if (nums[l]<nums[r]){
                res = Math.min(nums[l],res);
                break;
            }
            int m = (l+r)/2;
            res = Math.min(res,nums[m]);
            if (nums[m]>= nums[l]){
                l = m + 1;
            }else{
                r= m - 1;
            }
        }
        return res;
    }
}
