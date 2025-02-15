//https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSumII {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> cur, int total) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (total > target || i == candidates.length) {
            return;
        }

        cur.add(candidates[i]);
        backtrack(candidates, target, i + 1, cur, total + candidates[i]);
        cur.remove(cur.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, i + 1, cur, total);
    }
}
