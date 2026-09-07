class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int minTime = 0;
        int fresh = 0;
        for(int i=0 ; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else{
                    continue;
                }
            }
        }

        int[][] directions = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if(fresh == 0) return 0;

        while(!q.isEmpty() && fresh > 0){
            int length = q.size();
            for(int i = 0; i < length; i++){ 
                int[] copy = q.poll();
                int row = copy[0], col = copy[1];
                for(int[] direc : directions){
                    int r = direc[0] + row;
                    int c = direc[1] + col;
                    if(r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                        grid[r][c] != 1){
                            continue;
                    }
                    fresh--;
                    grid[r][c] = 2;
                    q.add(new int[]{r, c});
                }
            }
            minTime++;
        }
        return fresh == 0 ? minTime : -1;
    }
}
