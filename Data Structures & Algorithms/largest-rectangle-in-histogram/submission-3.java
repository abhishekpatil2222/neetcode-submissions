class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        for(int i =0; i < n; i++){
            int left = i-1;
            int right = i+1;
            while(left >=0 && heights[i] <= heights[left]) left--;
            while(right < n && heights[i] <= heights[right]) right++;

            right--;
            left++;

            res = Math.max(res, heights[i] * (right - left + 1));
        }
        return res;
    }
}
