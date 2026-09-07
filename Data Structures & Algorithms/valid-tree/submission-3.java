class Solution {
    List<List<Integer>> adj;
    Set<Integer> visited;

    public boolean validTree(int n, int[][] edges) {

        adj = new ArrayList<>();
        visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Cycle check
        if (!dfs(0, -1)) {
            return false;
        }

        // Connectivity check
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent) {

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int neighbour : adj.get(node)) {

            // Don't go back to where we came from
            if (neighbour == parent) {
                continue;
            }

            if (!dfs(neighbour, node)) {
                return false;
            }
        }

        return true;
    }
}