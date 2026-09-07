class Solution {
    List<List<Integer>> adj;
    Set<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            adj.add(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(visited.contains(i)) continue;
            dfs(i);
            res++;
        }
        return res;
    }
    public void dfs(int node){
        visited.add(node);
        for(int neigh : adj.get(node)){
            if(!visited.contains(neigh)){
                dfs(neigh);
            }
        }
        return;
    }
}
