package leetcode.dp;

import java.util.Arrays;

public class WineSelling {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 4};
        int n = arr.length;

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        int year = 1;

        System.out.println(maxProfit(arr, 0, n - 1, year, dp));
    }

    static int maxProfit(int[] arr, int s, int e, int year, int[][] dp) {
        if(s > e) return 0;
        if(dp[s][e] != -1) return dp[s][e];
        int left = arr[s] * year + maxProfit(arr, s + 1, e, year + 1, dp);
        int right = arr[e] * year + maxProfit(arr, s, e - 1, year + 1, dp);

        return dp[s][e] = Math.max(left, right);
    }
}
