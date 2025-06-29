
import java.util.Scanner;

public class LongestIncreasingSubsquence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(lis(arr));
    }
    

    static int lis(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // shurute sob elements er LIS 1 hobe
        }
        // dp[i] mane i index er element er upor depend kore LIS er length
        // dp[i] = max(dp[j] + 1) j < i and arr[i] > arr[j]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // j er LIS er upor depend kore i er LIS ta update korchi

                }
            }
        }
        // dp array er moddhe sobcheye boro LIS er length ta ber korbo
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
// Algo: Bottom Up DP
// 1. Start with an array dp where dp[i] represents the length of the longest increasing subsequence that ends with arr[i].
// 2. Initialize dp[i] to 1 for all i, since the minimum length of an increasing subsequence ending at any element is 1 (the element itself).
// 3. For each element arr[i], check all previous elements arr[j] (where j < i). If arr[i] > arr[j], it means we can extend the increasing subsequence ending at j to include i.
// 4. Update dp[i] as the maximum of its current value and dp[j] + 1.
// 5. Finally, the answer will be the maximum value in the dp array.

