
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // Single character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Two character substrings : 
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (maxLen < 2) {
                    start = i;
                    maxLen = 2;
                }
            }
        }

        // Length 3 to n substrings
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
// Algo: Bottom Up DP
// 1. Create a 2D boolean array dp where dp[i][j] indicates whether the substring s[i:j+1] is a palindrome.
// 2. Initialize dp[i][i] to true for all i, since single character substrings are palindromes.
// 3. For two character substrings, check if the characters are equal and set dp[i][i+1] accordingly.
// 4. For longer substrings, check if the first and last characters are equal and if the substring between them is a palindrome (using dp[i+1][j-1]).
// 5. Keep track of the starting index and maximum length of the longest palindromic substring found.
// 6. Return the substring from the original string using the starting index and maximum length.