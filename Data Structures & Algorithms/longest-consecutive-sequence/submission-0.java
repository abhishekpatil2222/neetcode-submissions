class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> num = new HashSet<>();
        for(int x : nums) num.add(x);
        int res = 1;
        for(int x : nums){
            int max = 1;
            if(num.contains(x-1)) continue;
            while(num.contains(x+1)){
                max++;
                x++;
            }
            if(max > res) res = max;
        }
        return res;
    }
}
