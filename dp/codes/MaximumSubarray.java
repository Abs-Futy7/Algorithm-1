
/*The maximum subarray problem is the task of finding the contiguous subarray within a one-dimensional array of numbers that has the largest sum. */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]); // Either start a new subarray at nums[i] or continue the previous subarray by adding nums[i]
            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// Algo: Bottom Up DP
// 1. Create a 1D array dp where dp[i] represents the maximum subarray sum ending at index i.
// 2. Initialize dp[0] to nums[0], since the maximum subarray sum ending at the first element is the element itself.
// 3. For each subsequent element, calculate dp[i] as the maximum of the current element nums[i] and the sum of dp[i-1] and nums[i]. This checks whether to start a new subarray or to continue the previous one.
// 4. Keep track of the maximum value found in dp as maxSum.
// 5. The answer will be in maxSum, which represents the maximum subarray sum in the array.

