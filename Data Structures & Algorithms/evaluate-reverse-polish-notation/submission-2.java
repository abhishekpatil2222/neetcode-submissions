class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> computer = new Stack<>();
        for(String c : tokens){
            if(c.equals("+")){
                computer.push(computer.pop() + computer.pop());
            }else if(c.equals("-")){
                int a = computer.pop();
                int b = computer.pop();
                computer.push(b - a);
            }else if(c.equals("*")){
                computer.push(computer.pop() * computer.pop());
            }else if(c.equals("/")){
                int a = computer.pop();
                int b = computer.pop();
                computer.push(b / a);
            }else{
                computer.push(Integer.parseInt(c));
            }
        }
        return computer.pop();
    }
}
