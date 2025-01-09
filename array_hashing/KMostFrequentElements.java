//https://leetcode.com/problems/top-k-frequent-elements/

public class Solution {
    /**
     * 1. Create a HashMap to store the frequency of each element in the input array.
     * 2. Iterate through the input array `nums` and Update the frequency of each element in the map using `getOrDefault`.:
     * 3. Create a list of integer arrays (`arr`) to store pairs of frequency and element.
     *    - Each pair is represented as an array where:
     *      - The first element is the frequency.
     *      - The second element is the value (the element from the input array).
     * 4. Populate the list by iterating through the entries of the map:
     *    - For each entry, add a new integer array `[frequency, element]` to the list.
     * 5. Sort the list in descending order based on the frequency:
     *    - Use a custom comparator to sort the arrays by the first value (frequency).
     * 6. Create an array `res` to store the k most frequent elements.
     *    - Iterate through the sorted list to extract the top k elements (the second value of each pair).
     * 7. Return the resulting array `res`.
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}