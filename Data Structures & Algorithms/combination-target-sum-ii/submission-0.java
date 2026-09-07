class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, cur, 0, candidates, target);
        return res;

    }
    public void dfs(int i, List<Integer> cur, int total, int[] candidates, int target){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i >= candidates.length || total > target){
            return;
        }
        
        cur.add(candidates[i]);
        dfs(i+1, cur, total + candidates[i], candidates, target);
        int j = i + 1;
        while( j < candidates.length && candidates[i] == candidates[j] )j++;
        cur.remove(cur.size() - 1);
        dfs(j, cur, total, candidates, target);
    }
}
