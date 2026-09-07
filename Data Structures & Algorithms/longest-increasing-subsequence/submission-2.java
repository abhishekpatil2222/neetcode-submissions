class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp.get(res - 1)){
                dp.add(nums[i]);
                res++;
            }else{
                int idx = Collections.binarySearch(dp, nums[i]);
                if(idx < 0) idx = -idx - 1;
                dp.set(idx, nums[i]);
            }
        }
        return res;
    }
}
