//https://leetcode.com/problems/evaluate-reverse-polish-notation/

public class EvaluateReversePolishNotation {
    /**
     * If the string is any mathematical expression pop the last two elements and do the operation
     * Otherwise push the number into the stack
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c:tokens){
            if (c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if (c.equals("-")){
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1-n2);
            }else if (c.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if (c.equals("/")){
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(n1/n2);
            }else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
