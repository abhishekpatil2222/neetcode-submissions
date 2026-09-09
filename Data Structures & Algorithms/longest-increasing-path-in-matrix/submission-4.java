class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[][] indegree = new int[ROWS][COLS];
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                for(int[] dir : directions){
                    int nr = dir[0] + r, nc = dir[1] + c;
                    if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS
                        && matrix[nr][nc] < matrix[r][c]){
                            indegree[r][c]++;
                        }
                }
                if(indegree[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }
        int LIS = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur[] = q.poll();
                int r = cur[0], c = cur[1];
                for(int[] dir : directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS 
                        && matrix[nr][nc] > matrix[r][c]){
                            if(--indegree[nr][nc] == 0){
                                q.offer(new int[]{nr, nc});
                            }
                        }
                }
            }
            LIS++;
        }
        return LIS;
    }
}
