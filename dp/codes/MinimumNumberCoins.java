
public class MinimumNumberCoins {

    public static void main(String[] args) {
        int[] coins = {1, 5, 7, 9};
        int amount = 12;
        System.out.println(minCoins(coins, amount));
    }

    static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        int INF = (int) 1e9;

        // Initialize: 0 coins => infinite coins needed (impossible) except amount 0
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; 
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        return dp[n][amount];
    }

}
