class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()){
            int[] copy = q.poll();
            int row = copy[0], col = copy[1];
            for(int[] direc : directions){
                int r = direc[0] + row;
                int c = direc[1] + col;
                if(r < 0 || c < 0 || r >= m || 
                c >= n || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }

                q.add(new int[]{r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
