//https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {
    /**
     * To calculate the area we would need the width which is different between r and l and minimum height
     * As the minimum height between l and r is the one we can use we will move our pointer based on which one is smaller
     * This was we can maximize minimum height
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int res = 0;

        while (l<r){
            int area = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res,area);

            if (height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
}
