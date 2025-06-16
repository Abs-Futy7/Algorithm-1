import java.util.*;

public class Fibonacci {

    // Top-down approach with memoization (recursive)
    static int topDown_memoization(int n){
        int[] memo = new int[n+1]; // Array to store computed Fibonacci values
        Arrays.fill(memo, -1);     // Initialize all values to -1 (uncomputed)

        // base case: Fibonacci(0) = 0, Fibonacci(1) = 1
        if(n<=1) return n;

        // Check if the result is already computed
        if(memo[n] != -1) return memo[n];

        // Recursive computation and store the result in memo[n]
        memo[n] = topDown_memoization(n-1) + topDown_memoization(n - 2);
        return memo[n];

        // Time Complexity: O(n)
        // Space Complexity: O(n) for memoization table + O(n) for recursion stack
    }  

    // Bottom-up approach with tabulation (iterative)
    static int bottomUP_tabulation(int n){
        if(n<=1) return n; // base case

        int[] dp = new int[n+1]; // Array to store Fibonacci values up to n
        dp[0] = 0; // Fibonacci(0)
        dp[1] = 1; // Fibonacci(1)

        // Build the table from 2 to n
        for(int i = 2 ; i <= n ; i++){
                dp[i] = dp[i-1] + dp[i-2]; // Each value is sum of previous two
        }
        return dp[n]; // Return the nth Fibonacci number

        // Time Complexity: O(n)
        // Space Complexity: O(n)
    }

    // Space optimized approach (only keep last two values)
    static int spaceOpt(int n){
        if(n<=1) return n; // base case

        int prev1 = 1; // Fibonacci(1)
        int prev2 = 0; // Fibonacci(0)

        // Only keep track of last two computed values
        for(int i = 2 ; i <=n ; i++){
                int curr = prev1 + prev2; // Current Fibonacci number
                prev2 = prev1;            // Update prev2 to previous prev1
                prev1 = curr;             // Update prev1 to current value
        }

        return prev1; // Return the nth Fibonacci number

        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Compute Fibonacci using all three methods
        int result1 = topDown_memoization(n);
        int result2 = bottomUP_tabulation(n);
        int result3 = spaceOpt(n);

        // Print results
        System.out.println("Fibonacci of " + n + " is: " + result1);
        System.out.println("Fibonacci of " + n + " is: " + result2);
        System.out.println("Fibonacci of " + n + " is: " + result3);

        sc.close();
    }
}
