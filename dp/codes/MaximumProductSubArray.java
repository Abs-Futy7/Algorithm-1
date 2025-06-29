public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }

    static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxProduct = dp[0];
        int minProduct = dp[0];
        int result = dp[0];

        for(int i = 1 ; i < n ; i++){
            int temp = maxProduct; // Store the previous max product
            maxProduct = Math.max(nums[i], Math.max(temp * nums[i], minProduct * nums[i])); // Either start a new subarray at nums[i] or continue the previous subarray
            minProduct = Math.min(nums[i], Math.min(temp * nums[i], minProduct * nums[i])); // Update minProduct
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// Algo: Bottom Up DP
// 1. Create a 1D array dp where dp[i] represents the maximum product subarray ending at index i.
// 2. Initialize dp[0] to nums[0], since the maximum product subarray ending at the first element is the element itself.
// 3. For each subsequent element, calculate dp[i] as the maximum of the current element nums[i], the product of dp[i-1] and nums[i], and the product of minProduct and nums[i]. This checks whether to start a new subarray or to continue the previous one.
// 4. Keep track of both the maximum and minimum products found so far, as negative numbers can turn a minimum product into a maximum product when multiplied.
// 5. The answer will be in result, which represents the maximum product subarray in the array.