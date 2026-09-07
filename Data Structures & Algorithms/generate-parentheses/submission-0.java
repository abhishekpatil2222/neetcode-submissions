class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backTrack(0, 0, n, stack);
        return res;
    }

    public void backTrack(int open, int closed,int n, StringBuilder stack){
        if(open == closed && open == n){
            res.add(stack.toString());
            return;
        }
        if(open < n){
            stack.append("(");
            backTrack(open + 1, closed, n, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if(closed < open){
            stack.append(")");
            backTrack(open, closed + 1, n, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
