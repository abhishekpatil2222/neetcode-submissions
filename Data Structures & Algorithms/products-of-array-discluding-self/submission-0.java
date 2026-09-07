class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroCount = 0;
        int index = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){zeroCount++;index = i;continue;}
            prod *= nums[i];

        }
        int[] res = new int[nums.length];
        if(zeroCount > 1) return new int[nums.length];
        if(zeroCount ==1) {res[index] = prod; return res;}
        
        for(int i=0; i < nums.length; i++){
         
                res[i] = prod / nums[i];
                
        }
        return res;
    }
}  
