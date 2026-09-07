class Solution {
    List<List<Integer>> adj;
    Set<Integer> cycle;
    public boolean validTree(int n, int[][] edges) {
        cycle = new HashSet<>();
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        if(dfs(0, -1) == false){
            return false;
        }
        return n == cycle.size();

    }
    public boolean dfs(int node, int parent){
        if(cycle.contains(node)){
            return false;
        }
        cycle.add(node);
        for(int neighbour : adj.get(node)){
            if(parent == neighbour){
                continue;
            }
            if(dfs(neighbour, node) == false){
                return false;
            }
        }
        return true;
    }
}
