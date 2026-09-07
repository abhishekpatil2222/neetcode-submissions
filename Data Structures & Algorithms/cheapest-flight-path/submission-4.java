class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i = 0; i < n; i ++)prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] temp = Arrays.copyOf(prices, n);

            for(int ticket[] : flights){
                int s = ticket[0], d = ticket[1], c = ticket[2];
                if(prices[s] == Integer.MAX_VALUE) continue;
                if(prices[s] + c < temp[d]){
                    temp[d] = prices[s] + c;
                }
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
    
}
