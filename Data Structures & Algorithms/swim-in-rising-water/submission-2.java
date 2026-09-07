class Solution {

    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!minHeap.isEmpty()){

            int[] cur = minHeap.poll();
            int r = cur[1], c = cur[2], val = cur[0];
            
            if((r == n-1) && (c == n - 1)){
                return val;
            }

            for(int[] dir : directions){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]){
                    continue;
                }
                visited[nr][nc] = true;
                minHeap.offer(new int[]{ Math.max(val, grid[nr][nc]), nr, nc});

            }
        }

        return n*n;
    }

}
