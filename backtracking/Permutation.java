//https://leetcode.com/problems/permutations/description/
public class Permutation {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(perm, nums, pick);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
}
