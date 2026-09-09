class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        dp[0][0] = 1; // 1 way to make amount 0

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {

                // Don't take coin
                dp[i + 1][j] = dp[i][j];

                // Take coin
                if (j >= coins[i]) {
                    dp[i + 1][j] += dp[i + 1][j - coins[i]];
                }
            }
        }

        return dp[n][amount];
    }
}