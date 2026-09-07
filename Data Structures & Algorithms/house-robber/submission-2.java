//My Top - Down approach

class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, 0);
        return dfs(nums, nums.length - 1);
    }
    public int dfs(int[] nums, int i){
        if(i < 0)
            return 0;
        
        if(memo[i] != 0) 
            return memo[i];
        memo[i] = Math.max(dfs(nums, i - 1), nums[i] + dfs(nums, i - 2));
        return memo[i];
    }
}
