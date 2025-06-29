
import java.util.Scanner;

public class PerfectSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numSquares(n));
        sc.close();
    }

    static int numSquares(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0; // Base case: 0 can be formed with 0 squares

        for(int i = 1 ; i <= n ; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1 ; j*j <= i ; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1); // Check all perfect squares less than or equal to i
            }
        }
        return dp[n];
    }
}

// Time Complexity: O(n * sqrt(n))
// Space Complexity: O(n)
// Algo: Bottom Up DP
// 1. Create a 1D array dp where dp[i] represents the minimum number of perfect squares that sum up to i.
// 2. Initialize dp[0] to 0, since 0 can be formed with 0 squares.
// 3. For each number i from 1 to n, initialize dp[i] to Integer.MAX_VALUE.
// 4. For each perfect square j*j less than or equal to i, update dp[i] as the minimum of its current value and dp[i - j*j] + 1 (which represents using one more square).
// 5. The answer will be in dp[n], which represents the minimum number of perfect squares that sum up to n.