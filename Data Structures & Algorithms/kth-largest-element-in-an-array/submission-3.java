class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    public int quickSelect(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int p = left;
        for(int i=left; i < right; i++){
            if(nums[i] <= pivot){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        int temp = nums[right];
        nums[right] = nums[p];
        nums[p] = temp;

        if(p < k){
            return quickSelect(nums, p+1, right, k);
        }else if(p > k){
            return quickSelect(nums,left,p-1, k);
        }else{
            return nums[p];
        }
    }
}
