class DSU{
    int[] Parent, Size;
    public DSU(int n){
        Parent = new int[n];
        Size = new int[n];
        for(int i = 0; i < n; i++){
            Size[i] = 1;
            Parent[i] = i;
        }
    }
    public int find(int node){
        while(node != Parent[node]){
            node = Parent[node];
        }
        return Parent[node];
    }
    public boolean union(int n, int u){
        int pn = find(n), pu = find(u);
        if(pn == pu) return false;
        if(Size[pn] < Size[pu]){
            int t = pu;
            pu = pn;
            pn = t;
        }
        Size[pn] += Size[pu];
        Parent[pu] = pn;
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        edges.sort((a,b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for(int[] edge : edges){
            if(dsu.union(edge[1], edge[2])){
                res += edge[0];
            }
        }
        return res;
    }
}
