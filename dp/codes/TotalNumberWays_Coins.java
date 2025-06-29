
import java.util.Scanner;

public class TotalNumberWays_Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0 ; i < n ; i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        System.out.println(totalNumberCoins(coins, amount, n));
        sc.close();
    }

    static int totalNumberCoins(int[] coins, int amount, int n) {
        int[][] dp = new int[n+1][amount + 1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = 1; // Base case: There is one way to make amount 0 (by choosing no coins)
        }

        for(int i = 1; i <= n ; i++){
            for(int j = 0 ; j <= amount ; j++){
                    if(coins[i-1] > j){
                        dp[i][j] = dp[i-1][j]; // If the coin value is greater than the amount, copy the value from the upper row
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + (dp[i][j - coins[i-1]]); // Include the coin or exclude it
                    }
                }
            }
        return dp[n][amount];
    }
}


// Time Complexity: O(n * amount)
// Space Complexity: O(n * amount)
// Algo: Bottom Up DP
// 1. Create a 2D array dp where dp[i][j] represents the number of ways to make amount j using the first i coins.
// 2. Initialize dp[i][0] to 1 for all i, since there is one way to make amount 0 (by choosing no coins).
// 3. For each coin, iterate through all amounts from 0 to the target amount.
// 4. If the coin value is greater than the current amount, copy the value from the upper row (dp[i-1][j]).
// 5. If the coin value is less than or equal to the current amount, calculate the number of ways by including the coin (dp[i][j - coins[i-1]]) and excluding it (dp[i-1][j]).
// 6. The answer will be in dp[n][amount], which represents the total number of ways to make the target amount using all available coins.