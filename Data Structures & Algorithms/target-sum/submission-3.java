class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            Map<Integer, Integer> nextDp = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()){
                int total = entry.getKey();
                int count = entry.getValue();
                nextDp.put(total + nums[i],
                    nextDp.getOrDefault(total + nums[i], 0) + count);
                nextDp.put(total - nums[i],
                    nextDp.getOrDefault(total - nums[i], 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}
