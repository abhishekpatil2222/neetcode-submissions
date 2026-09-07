class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int l = 0;
        int r = heights.length-1;
        while(l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);
            if(area > max) max = area;
            if(heights[l] >= heights[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}
