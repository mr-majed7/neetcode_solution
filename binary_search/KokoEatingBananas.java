//https://leetcode.com/problems/koko-eating-bananas/description/

public class KokoEatingBananas {
    /**
     * In the given problem H will always be greater than number of piles
     * So our answer would be in the worst case the largest pile size
     * If we use brute force what we can do is from 1 to max pile size we would iterate and find the minimum number
     * that would fit.
     * We can optimize that
     * Instead of iterating from 1 to m we can use binary search to find the minimum number as 1-n is sorted
     */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        int res = r;

        while (l<=r){
            int m = (l+r)/2;

            long t = 0;
            for (int p: piles){
                t  += Math.ceil((double) p / m);
            }

            if (t<=h){
                res = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return res;
    }
}
