class Solution {
    Map<Integer, List<int[]>> adj;
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new HashMap<>();
        for(int[] edge : times){
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        dist = new HashMap<>();
        for(int i = 1; i <= n; i++){
            dist.put(i, Integer.MAX_VALUE);
        }

        dfs(k, 0);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;

    }
    public void dfs(int node, int len){
        if(len >= dist.get(node)) return;
        dist.put(node, len);
        if(!adj.containsKey(node)) return;
        for(int[] edge : adj.get(node))
            dfs(edge[0], len + edge[1]);
        
    }
}
