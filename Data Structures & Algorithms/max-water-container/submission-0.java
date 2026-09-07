class Solution {
    public int maxArea(int[] heights) {
        int max = -1;

        for(int i=0 ; i < heights.length; i++){
            for(int j=0; j < heights.length; j++){
                int volume = (Math.abs(j-i))*(Math.abs(Math.min(heights[i], heights[j])));
                if(volume > max) max = volume;
            }
        }
        return max;
    }
}
