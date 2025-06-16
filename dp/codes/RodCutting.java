import java.util.Scanner;

public class RodCutting {
    static int rodCutting_rec(int[] prices, int n){
        // Base case: no rod left to cut
        if(n<=0) return 0;

        int ans = 0;

        // Try all possible first cuts (from length 1 to n)
        for(int i = 1 ; i <= n ; i++){
            // Recursively calculate the profit for the remaining rod (n - i)
            // and add the price of the current cut (prices[i-1])
            ans = Math.max(ans, prices[i-1] + rodCutting_rec(prices, n - i));
        }
        return ans; 
    }


    static int rodCut_tabulation(int[] prices, int n){

        int[] dp = new int[n+1];
        dp[0] = 0;
        // Build the table from 1 to n
        for(int i = 1 ; i <= n ; i++){
            int ans = 0;
            // Try all possible first cuts (from length 1 to i)
            for(int j = 1 ; j <= i ; j++){
                // Update the maximum profit for length i
                ans = Math.max(ans, prices[j-1] + dp[i - j]);
            }
            dp[i] = ans; // Store the maximum profit for length i
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
    
        System.out.println("Maximum profit: " + rodCutting_rec(prices, n));
        System.out.println("Maximum profit (Tabulation): " + rodCut_tabulation(prices, n));
        sc.close();
    }
}
