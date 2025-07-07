package lab.eval_lab3;

import java.util.*;

public class Treasure {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int w = sc.nextInt();

        int[] weight = new int[n];

        int[] value = new int[n];

        for (int i = 0; i < n; i++) {

            weight[i] = sc.nextInt();

            value[i] = sc.nextInt();

        }

        knapsack(weight, value, w, n);

    }

    static void knapsack(int[] weights, int[] values, int C, int n) {

        int[][] dp = new int[n + 1][C + 1];

        int[] tres = new int[n];

        int idx = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= C; j++) {

                if (weights[i - 1] <= j) {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);

                } else {

                    dp[i][j] = dp[i - 1][j];

                }

            }

        }

        System.out.println(dp[n][C]);

        int i = n, j = C;

        while (i > 0 && j > 0) {

            if (dp[i][j] != dp[i - 1][j]) {

                tres[idx++] = i;

                j -= weights[i - 1];

            }

            i--;

        }

        for (int k = idx - 1; k >= 0; k--) {

            if (k != 0)
                System.out.print(tres[k] + " ");

            else
                System.out.println(tres[k]);

        }

    }

}