class Solution {
    public int search(int[] nums, int target) {
        int l = 0; 
        int r = nums.length - 1;
        while(l < r){
            int mid = (l+r) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        int pivot = l;
        l = 0;
        r = nums.length - 1;

        if(target >= nums[pivot] && target <= nums[r]){
            l = pivot ;
        }else{
            r = pivot-1;
        }

        while(l <=r ){
            int m = (l + r) / 2;
            if(target == nums[m]){
                return m;
            }else if(target > nums[m]){
                l = m+1;
            }else{
                r = m-1;
            }
        }

        return -1;
    }
}
