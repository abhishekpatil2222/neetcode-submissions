class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS, COLS;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        dp = new int[ROWS][COLS];
        int res = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                res = Math.max(res, dfs(i, j, matrix));
            }
        }
        return res;
    }
    public int dfs(int r, int c, int[][] matrix) {
        
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        int lip = 0;
        for (int[] dir : directions) {
            int nr = dir[0] + r, nc = dir[1] + c;
            if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && matrix[r][c] < matrix[nr][nc]) {
                lip = Math.max(lip, dfs(nr, nc, matrix));
            }
        }
        dp[r][c] = lip + 1;
        return lip + 1;
    }
}
