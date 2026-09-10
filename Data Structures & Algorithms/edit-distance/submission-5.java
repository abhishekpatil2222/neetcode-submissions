class Solution {
    public int minDistance(String word1, String word2) {
        //space optimized dp solution
        int m = 0, n = word2.length();
        int dp[] = new int[n + 1];
        for(int i = 0; i <= n; i++) dp[i] = i;
        for(char c : word1.toCharArray()){
            int[] nextDp = new int[n + 1];
            nextDp[0] = ++m;
        
            for(int i = 1; i <= n; i++){
                if(c == word2.charAt(i - 1)){
                    nextDp[i] = dp[i - 1];
                }else{
                    nextDp[i] = 1 + Math.min(
                                Math.min(nextDp[i - 1], dp[i]),
                                dp[i - 1]);
                }
            }
            for(int ni : nextDp) System.out.print(ni + " ");
            System.out.println("");
            dp = nextDp;
        }
        return dp[n];

    }
}
