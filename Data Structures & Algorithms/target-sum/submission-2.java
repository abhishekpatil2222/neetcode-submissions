class Solution {
    Map<Pair<Integer, Integer>, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(0, 0, nums, target);
    }
    public int dfs(int i, int total, int[] nums, int target){
        if(i >= nums.length){
            if(total == target) 
                return 1;
            else
                return 0;
        }
        Pair<Integer, Integer> state = new Pair<>(i, total);
        if(memo.containsKey(state)){
            return memo.get(state);
        }
        memo.put(state, dfs(i + 1, total + nums[i], nums, target) +
               dfs(i + 1, total - nums[i], nums, target));
        return memo.get(state);
    }
}
