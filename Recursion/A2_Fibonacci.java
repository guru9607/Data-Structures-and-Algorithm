package Recursion;

public class A2_Fibonacci {
    //Solution 1: Iterative - Space Optimized (Best for interviews)
    // TC => O(n)
    // SC => O(1)
    public static int fibIterative(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev0 = 0, prev1 = 1, result = 0;

        for (int i = 2; i <= n; i++) {
            result = prev0 + prev1;
            prev0 = prev1;
            prev1 = result;
        }
        return result;
    }

    // -----------------------------------------------------------------------
    // Solution 2: Recursive - Brute Force => Not recommended for large n. Use only to demonstrate recursion.
    // TC => O(n)
    // SC => O(n)
    public static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // -----------------------------------------------------------------------
    // Solution 3: Dynamic Programming - Top Down (Memoization) => Good for recursive understanding + avoids redundant calls
    // TC => O(n)
    // SC => O(n)
    
    static int[] memo = new int[31]; // Use 10^5+1 for large inputs

    public static int fibTopDown(int n) {
        if (n <= 1) return n;

        if (memo[n] != 0) return memo[n];

        return memo[n] = fibTopDown(n - 1) + fibTopDown(n - 2);  // saving and returning
    }

    // -----------------------------------------------------------------------
    // Solution 4: Dynamic Programming - Bottom Up (Tabulation) => Straightforward iterative approach with array
    // TC => O(n)
    // SC => O(n)
    public static int fibBottomUp(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        int n = 10;

        System.out.println("Fibonacci of " + n + ":");
        System.out.println("1. Iterative (O(1) space):        " + fibIterative(n));
        System.out.println("2. Recursive (brute):             " + fibRecursive(n));
        System.out.println("3. DP Top-Down (memoization):     " + fibTopDown(n));
        System.out.println("4. DP Bottom-Up (tabulation):     " + fibBottomUp(n));
    }
}
