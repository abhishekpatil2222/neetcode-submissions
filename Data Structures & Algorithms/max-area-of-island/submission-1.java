class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if(pu == pv) return false;
        if(size[pu] < size[pv]){
            size[pv] += size[pu];
            parent[pu] = pv;
        }else{
            size[pu] += size[pv];
            parent[pv] = pu;
        }
        return true;
    }
    public int getSize(int node){
        return size[find(node)];
    }
}

class Solution {
    int[][] directions = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        DSU dsu = new DSU(ROWS * COLS);
        int area = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    for(int[] dir : directions){
                        int nr = r + dir[0], nc = c + dir[1];
                        if(nr >= 0 && nc >= 0&& nr < ROWS && nc < COLS && grid[nr][nc] == 1 ){
                            dsu.union(r * COLS + c, nr * COLS + nc);
                        }
                    }
                    area = Math.max(area, dsu.getSize(r * COLS + c));
                }
            }
        }
        return area;
    }
}
