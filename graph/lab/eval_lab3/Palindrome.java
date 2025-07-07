package lab.eval_lab3;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n = s.length();

        System.out.println(ans(s, n));

    }

    static int ans(String s, int n) {

        int[][] dp = new int[n + 1][n + 1];

        char[] rev = new char[n];

        for (int i = 0; i < n; i++) {

            rev[i] = s.charAt(n - 1 - i);

        }  // reverse nilam

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == rev[j - 1]) {

                    // jodi mile
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // na mille

                }

            }

        }

        return n - dp[n][n];

    }

}
