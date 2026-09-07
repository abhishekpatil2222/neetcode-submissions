class Solution {
    int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    int rows, cols;
    
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> altQ = new LinkedList<>();

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] alt = new boolean[rows][cols];

        List<List<Integer>> res = new ArrayList<>();

        for(int c = 0; c < cols; c++){
            pacQ.add(new int[]{0, c});
            altQ.add(new int[]{rows - 1, c});
        }
        for(int r = 0; r < rows; r++){
            pacQ.add(new int[]{r, 0});
            altQ.add(new int[]{r, cols - 1});
        }
        bfs(pacQ, pac, heights);
        bfs(altQ, alt, heights);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pac[i][j] && alt[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    public void bfs(Queue<int[]> q,boolean[][] ocean, int[][] heights){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for(int[] dir : directions){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols &&
                    !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                        q.add(new int[]{nr, nc});
                    }
            }
        }
    }
}
