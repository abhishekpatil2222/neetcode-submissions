class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        return backTrack(0, 0, sum, nums);
        
    }
    public boolean backTrack(int i, int total, int sum, int[] nums){
         if(total == sum) return true;
         if(total > sum || i >= nums.length) return false;
         
         return (backTrack(i + 1, total + nums[i], sum, nums)) ||
                (backTrack(i + 1, total, sum, nums));

         
    }
}
