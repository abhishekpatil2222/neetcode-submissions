class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, top[1] * (i - top[0]));
                start = top[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        for(int[] pair : stack){
            maxArea = Math.max(maxArea, pair[1] * (heights.length - pair[0]));
        }

        return maxArea;
    }
}
