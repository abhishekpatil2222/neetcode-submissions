class MinStack {
    public Stack<Long> stack;
    long min = -1;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }else{
            stack.push(val-min);
            if(val - min < 0) min = val;
        }

    }
    
    public void pop() {
        Long top = stack.pop();
        if(top <= 0) min = min - top;
    }
    
    public int top() {
    Long top = stack.peek();
    if(top > 0) {
        return (int)(top + min);
    }
    else{
        return (int)min;
    }
    }
    
    public int getMin() {
        return (int)min;
    }
}
