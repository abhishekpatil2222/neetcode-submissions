class Solution {
    Map<Pair<Integer, Boolean>, Integer> dp;
    public int maxProfit(int[] prices) {
        dp = new HashMap<>();
        return dfs(0, true, prices);
    }
    int dfs(int i, boolean buying, int[] prices){
        if(i >= prices.length){
            return 0;
        }
        Pair<Integer, Boolean> state = new Pair<>(i, buying);
        if(dp.containsKey(state)){
            return dp.get(state);
        }
        int cooldown = dfs(i + 1, buying, prices);
        if(buying){
            int buy = dfs(i + 1, false, prices) - prices[i];
            dp.put(state, Math.max(buy, cooldown));
        }else{                                  
            int sell = dfs(i + 2, true, prices) + prices[i];
            dp.put(state, Math.max(sell, cooldown));
        }
        return dp.get(state);
    }
}
