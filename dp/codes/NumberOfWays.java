
import java.util.Scanner;

public class NumberOfWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 7;
        for(int i = 6 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4]  + dp[i-6];
        }

        System.out.println(dp[n]);
        sc.close();
    }
}
