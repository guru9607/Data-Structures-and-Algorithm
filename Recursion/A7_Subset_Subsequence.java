package Recursion;

import java.util.ArrayList;
import java.util.List;

public class A7_Subset_Subsequence {

    // ========================
    // Q.1 Subset of Integers
    // ========================
    /*
     * Subset: All combinations of including/excluding each element.
     * Input: [1, 2]
     * Output: [[], [2], [1], [1, 2]]
     * 
     * This is a classic backtracking problem:
     * At each index, we decide:
     *    - Exclude the current number
     *    - Include the current number
     * 
     * We use backtracking — i.e., undo the addition after recursive call (output.remove(...))
     * because `List<Integer>` is mutable and reused across calls.
     */
    public void generatesubsets(int[] nums, List<Integer> output, int index, List<List<Integer>> ans) {
        if (index >= nums.length) {
            // Deep copy the current subset
            ans.add(new ArrayList<>(output));
            return;
        }

        // Exclude
        generatesubsets(nums, output, index + 1, ans);

        // Include
        output.add(nums[index]);
        generatesubsets(nums, output, index + 1, ans);

        //  Backtrack (remove the included element)
        output.remove(output.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        generatesubsets(nums, output, index, ans);

        return ans;
    }

    // ========================
    // Q.2 Subsequences of String
    // ========================
    /*
     * Subsequence: A sequence that can be derived by deleting 0 or more characters, preserving order.
     * Input: "ab"
     * Output: ["", "b", "a", "ab"]
     * 
     * This also follows the same include/exclude pattern as subsets.
     * But since strings are immutable, we don't need to "remove" after the recursive call.
     */
    static void generateSubsequence(String str, String output, int index, List<String> ans) {
        if (index >= str.length()) {
            ans.add(output);
            return;
        }

        // Exclude
        generateSubsequence(str, output, index + 1, ans);

        // Include
        generateSubsequence(str, output + str.charAt(index), index + 1, ans);
    }

    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> ans = new ArrayList<>();
        String output = "";
        int index = 0;

        generateSubsequence(str, output, index, ans);

        return ans;
    }

    public static void main(String[] args) {
        // Test subsequences
        String str = "ab";
        ArrayList<String> result = subsequences(str);
        System.out.println("Subsequences of \"" + str + "\": " + result);

        // Test subsets
        int[] nums = {1, 2};
        A7_Subset_Subsequence obj = new A7_Subset_Subsequence();
        List<List<Integer>> subsetResult = obj.subsets(nums);
        System.out.println("Subsets of [1, 2]: " + subsetResult);
    }
}


