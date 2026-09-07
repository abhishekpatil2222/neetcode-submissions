class Solution {
    public int search(int[] nums, int target) {
        for(int x=0; x < nums.length; x++){
            if(nums[x] == target) return x;
        }
        return -1;
    }
}
