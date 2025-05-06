
public class MinCoinChange{
    public static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize the first row (0 coins) with a large number (except dp[0][0])
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1; // Use -1 to avoid overflow when adding 1 later
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // Coin too big, copy from above
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // min(exclude new coin, 1 + include new coin)
                }
            }
        }

        if (dp[n][amount] == Integer.MAX_VALUE - 1) {
            return -1; // Not possible to form the amount with given coins
        } else {
            return dp[n][amount]; // Return the minimum number of coins
        }
        
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 7, 9};
        int amount = 11;

        int result = minCoins(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}

/*
Algorithm: Minimum Coin Change (DP approach)

Input:

    coins[]: array of coin denominations

    amount: target amount

Output:

    Minimum number of coins needed to make the amount (or -1 if not possible)

Steps:

    Initialize a 2D DP table dp[n+1][amount+1], where n is the number of coins.

        dp[i][j] means minimum coins to make amount j using first i coins.

    Base case:

        Set all dp[0][j] = ∞ (a very large number like Integer.MAX_VALUE - 1) for j > 0 → can't make any amount with 0 coins.

        Set all dp[i][0] = 0 → 0 coins needed to make amount 0.

    Fill the DP table:

        For each coin i from 1 to n:

            For each amount j from 0 to amount:

                If coins[i-1] > j:

                    Copy value from the row above:
                    dp[i][j] = dp[i-1][j]

                Else:

                    Choose the minimum of:

                        Not using the coin: dp[i-1][j]

                        Using the coin: 1 + dp[i][j - coins[i-1]]

                    So,
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])

    Final Answer:

        If dp[n][amount] == ∞, return -1 (no solution)

        Else, return dp[n][amount]
 */
