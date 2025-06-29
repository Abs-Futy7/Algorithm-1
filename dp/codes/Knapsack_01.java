
import java.util.Scanner;

public class Knapsack_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int C = sc.nextInt();
        System.out.println(knapsack(weights, values, C, n));

    }

    static int knapsack(int[] weights, int[] values, int C, int n) {
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                    // j theke weights[i-1] baire hole, oi item ta include korte parbo na
                    // tai dp[i][j] = dp[i-1][j]
                    // j theke weights[i-1] er value kom hole, oi item ta include korte pari
                    // tai dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]] + values[i-1])
                } else {
                    dp[i][j] = dp[i - 1][j];
                    // j theke weights[i-1] baire hole, oi item ta include korte parbo na
                    // tai dp[i][j] = dp[i-1][j]
                }
            }
        }

        return dp[n][C];
    }
}

// Time Complexity: O(n * C)
// Space Complexity: O(n * C)
// Algo: Bottom Up DP
// 1. Create a 2D array dp where dp[i][j] represents the maximum value that can be obtained with the first i items and a capacity of j.
// 2. Initialize dp[0][j] to 0 for all j, since with 0 items, the maximum value is 0.
// 3. For each item i and each capacity j, check if the weight of the item is less than or equal to j.
// 4. If it is, update dp[i][j] as the maximum of not including the item (dp[i-1][j]) and including the item (dp[i-1][j - weights[i-1]] + values[i-1]).
// 5. If the weight of the item is greater than j, then dp[i][j] is simply dp[i-1][j].
// 6. The answer will be in dp[n][C], which represents the maximum value that can be obtained with n items and capacity C.