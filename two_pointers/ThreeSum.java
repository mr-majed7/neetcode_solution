//https://leetcode.com/problems/3sum/description/

public class ThreeSum {
    /**
     * Sort the array to solve the duplicate issue and two be able to use two pointers
     * In the sorted array if an element is same as the element before that we will skip it as it is duplicate
     * First we will pick a number
     * After that we will do two sum to find second two numbers
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i<nums.length; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i+1;
            int r = nums.length-1;

            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];

                if (sum>0){
                    r--;
                }else if (sum<0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }

            }
        }
        return res;

    }
}
