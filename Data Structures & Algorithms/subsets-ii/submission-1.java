class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        int prevIdx = 0, idx = 0;

        for(int i = 0; i < nums.length; i++){
            idx = (i >= 1 && nums[i] == nums[i-1])? prevIdx : 0;
            prevIdx = res.size();
            for(int j = idx; j < prevIdx; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }

        return res;
    }
}
