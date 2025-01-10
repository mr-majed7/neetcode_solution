//https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

public class ValidParenthesis {
    /**
     * Create a hashmap of opening and closing parentheses
     * For each character check if it is in the hashmap as key
     * If it is closing parentheses than it will be
     * For closing parentheses if the top element in the stack equals to the opening one than pop
     * If not return false
     * Push the opening parentheses to the stuck
     * Finally return True if stack is empty; False otherwise
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        java.util.Map<Character, Character> closeToOpen = new java.util.HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c:s.toCharArray()){
            if (closeToOpen.containsKey(c)){
                if (!stack.isEmpty() && stack.peek()==closeToOpen.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
