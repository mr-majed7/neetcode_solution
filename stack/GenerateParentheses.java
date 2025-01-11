//https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses {
    /**
     * We will use recursion to generate parentheses
     * At each point we have two choice. To add opening or closing parentheses
     * We can add a opening parentheses if we have less than n openings
     * We can add closing if we have less closing than openings
     * So for both we will recursively backtrack and call our helper function
     */
    public void addParentheses(int open, int closed, int n, List<String> res, StringBuilder stack){
        if (open==closed && open==n){
            res.add(stack.toString());
            return;
        }

        if (open<n){
            stack.append("(");
            addParentheses(open+1,closed,n,res,stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closed<open){
            stack.append(")");
            addParentheses(open,closed+1,n,res,stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        addParentheses(0,0,n,res,stack);
        return res;
    }
}
