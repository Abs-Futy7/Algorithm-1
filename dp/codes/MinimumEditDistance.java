

/*Given two strings str1 and str2 and below operations that can be performed on str1.
Find the minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.  

    Insert
    Remove
    Replace

All of the above operations are of equal cost.  */


public class MinimumEditDistance {
    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "eacb";
        System.out.println(minEditDistance(s1, s2));
    }

    static int minEditDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = i; // If s2 is empty, we need i deletions
        }

        for(int j = 0 ; j <= m ; j++){
            dp[0][j] = j; // If s1 is empty, we need j insertions
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // Characters match, copy the value from the diagonal
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));  // Consider delete, insert, and replace operations
                }
            }
        }
        return dp[n][m];
    }
}


// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
// Algo: Bottom Up DP
// 1. Create a 2D array dp where dp[i][j] represents the minimum edit distance between the first i characters of s1 and the first j characters of s2.
// 2. Initialize dp[i][0] to i for all i, since converting the first i characters of s1 to an empty string requires i deletions.
// 3. Initialize dp[0][j] to j for all j, since converting an empty string to the first j characters of s2 requires j insertions.
// 4. For each character in s1 and s2, if they match, copy the value from the diagonal (dp[i-1][j-1]).
// 5. If they do not match, calculate the minimum edit distance considering deletion, insertion, and replacement operations.
// 6. The answer will be in dp[n][m], which represents the minimum edit distance between the two strings.