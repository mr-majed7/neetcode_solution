//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchSortedRotatedArray {
    /**
     * Because of rotation the array is still sorted but in has two partition We
     * will do binary search but have to figure out our middle value belongs to
     * which partition After figuring that out we can write index update condition
     * according to it
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
