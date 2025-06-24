// https://leetcode.com/problems/maximum-subarray/

class MaximumSubarrayVariants {

    /*
    ================================================================================  
    ✅ Brute Force – MAXIMUM SUBARRAY SUM (My Raw First Attempt)
    ================================================================================

    => Intuition:
    - So the problem is clear: we need to find the subarray (contiguous) that gives the max sum.
    - I started thinking the most basic way: let’s try **every possible subarray**, calculate its sum, and update the max.
    - It’s brute force for sure, but at least it guarantees correctness.

    => Approach:
    - I’ll use 3 nested loops:
        - First loop picks starting index `i`
        - Second loop picks ending index `j`
        - Third loop from i to j calculates the sum of subarray
    - After calculating sum, I’ll check if it's greater than current max and update `maxi`.

    => Dry Run (basic to confirm it works):
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

    i = 3, j = 6 → subarray = [4, -1, 2, 1]
    sum = 4 + (-1) + 2 + 1 = 6 → maxi = 6 ✅
    Final result → max sum = 6 from subarray [4, -1, 2, 1] ✅

    => Pseudocode:
    maxi = -∞
    for i = 0 to n-1:
        for j = i to n-1:
            sum = 0
            for k = i to j:
                sum += nums[k]
            maxi = max(maxi, sum)
    return maxi

    TC: O(n³) → Definitely too slow for large inputs (like n = 10^5)
    SC: O(1)

    This was my starting point before optimizing it — slow but solid.
    ================================================================================
    */

    public int maxSubArrayBrute(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }

    /*
    ================================================================================
    ✅ Better Brute Force – MAXIMUM SUBARRAY SUM (My Real Intuition Before Kadane)
    ================================================================================

    => Intuition:
    - Okay so brute force had 3 loops which is way too slow (O(n³)).
    - What clicked was — when I calculate sum from i to j using a 3rd loop,
    I’m basically doing extra work.
    - Instead, why not just keep adding nums[j] to a running sum as we move j?
    - That way I don't need the third loop — and time becomes O(n²)

    => Approach:
    - I’ll run two loops:
        - First loop for starting index i
        - Second loop for ending index j (starting from i)
        - Keep a `sum` variable, add nums[j] as we move
        - At each step, update `maxi` with max of current sum

    => Dry Run (enough to get confidence):
    nums = [-2, 1, -3, 4]

    i = 0 → sum = 0
    j = 0 → sum = -2 → maxi = -2
    j = 1 → sum = -1 → maxi = -1
    j = 2 → sum = -4 → maxi = -1
    j = 3 → sum = 0  → maxi = 0

    i = 1 → sum = 0
    j = 1 → sum = 1  → maxi = 1 ✅
    j = 2 → sum = -2
    j = 3 → sum = 2  → maxi = 2 ✅

    Final result → max sum = 6 from subarray [4, -1, 2, 1] ✅

    => Pseudocode:
    maxi = -∞
    for i = 0 to n-1:
        sum = 0
        for j = i to n-1:
            sum += nums[j]
            maxi = max(maxi, sum)
    return maxi

    ⏱️ Time: O(n²)
    📦 Space: O(1)
    ================================================================================
    */

    public int maxSubArrayBetter(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j]; 
                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }

    /*
    ================================================================================
    ✅ Kadane’s Algorithm – MAXIMUM SUBARRAY SUM (Final Linear Time Solution)
    ================================================================================

    🔍 Intuition:
    - Let’s try solving this in linear time — can we do it or not? Let’s think.
    - We’ll loop through the array just once.
    - We’ll maintain:
        🔸 `sum` → to keep track of the current subarray sum
        🔸 `maxi` → to store the maximum sum seen so far

    - Now suppose we’re at the very first element:
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

    i = 0 → sum = -2 → maxi = -2 → reset sum to 0  
    i = 1 → sum = 1   → maxi = 1 ✅  
    i = 2 → sum = -2  → reset to 0  
    i = 3 → sum = 4   → maxi = 4 ✅  
    i = 4 → sum = 3  
    i = 5 → sum = 5   → maxi = 5 ✅  
    i = 6 → sum = 6   → maxi = 6 ✅  
    ...

    Final result → max sum = 6 from subarray [4, -1, 2, 1] ✅

    🧾 Pseudocode:
    maxi = -∞  
    sum = 0  
    for i = 0 to n-1:  
        sum += nums[i]  
        maxi = max(maxi, sum)  
        if (sum < 0) sum = 0  
    return maxi

    🕒 Time Complexity: O(n)
    📦 Space Complexity: O(1)
    ================================================================================
    */

    public int maxSubArrayBest(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if (sum < 0) sum = 0;
        }

        return maxi;
    }

    // ✅ Kadane’s variant to also print the actual subarray
    public void printMaxSubArrayBest(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int ansStart = 0;
        int ansEnd = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        System.out.print("Subarray with max sum: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("Maximum Subarray Sum: " + maxi);
    }

    // Main method for quick testing
    public static void main(String[] args) {
        MaximumSubarrayVariants solver = new MaximumSubarrayVariants();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Brute Force: " + solver.maxSubArrayBrute(nums));
        System.out.println("Better Brute: " + solver.maxSubArrayBetter(nums));
        System.out.println("Kadane's Algo: " + solver.maxSubArrayBest(nums));
        solver.printMaxSubArrayBest(nums);
    }
}
