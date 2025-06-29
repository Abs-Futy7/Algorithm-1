
import java.util.Scanner;

public class RockClimbing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxPathSum(mat, r, c));
    }

    static int maxPathSum(int[][] mat, int r, int c) {
        // Pad with two extra columns
        int[][] dp = new int[r][c + 2];

        // Fill padding columns with Integer.MAX_VALUE
        for (int i = 0; i < r; i++) {
            dp[i][0] = Integer.MAX_VALUE;       // Left padding
            dp[i][c + 1] = Integer.MAX_VALUE;   // Right padding

            // Copy original matrix into the middle columns
            for (int j = 0; j < c; j++) {
                dp[i][j + 1] = mat[i][j];
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
            }
        }

        // Find min value in the last row (within original columns)
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= c; j++) {
            min = Math.min(min, dp[r - 1][j]);
        }

        return min;
    }
}
