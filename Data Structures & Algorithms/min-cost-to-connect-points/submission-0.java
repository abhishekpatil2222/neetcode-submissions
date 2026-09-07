class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int node = 0;
        boolean[] visit = new boolean[n];
        int edges = 0, res = 0;

        while(edges < n-1){
            visit[node] = true;
            int nextNode = -1;
            for(int i = 0; i < n; i++){
                if(visit[i]) continue;
                int curDist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                dist[i] = Math.min(dist[i], curDist);
                if(nextNode == -1 || dist[i] < dist[nextNode]){
                    nextNode = i;
                }
            }
            res += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return res;
    }
}
