class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        int res = 0;
        for(int i = n - 1; i >= 0; i--){
            int nxt = 0;
            for(int j = i + 1; j < n; j++){

                if(nums[i] < nums[j]){
                    nxt = Math.max(nxt, dp[j]);
                }
            }
            dp[i] = nxt + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
