//https://leetcode.com/problems/daily-temperatures/submissions/

public class DailyTemp {
    /**
     * A monotonic stack is maintained.
     * In the stack we will push the temperature with it's index
     * If we encounter a temperature that is greater than the top element of the stack we will pop
     * Also push the new temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<temperatures.length; i++){
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp>stack.peek()[0]){
                int[] data = stack.pop();
                res[data[1]] = i - data[1];

            }
            stack.push(new int[] {temp,i});
        }
        return res;


    }
}
