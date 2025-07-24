package Recursion;

import java.util.*;

public class A8_Permutation {
    private static void solve(int[] nums, int index, List<List<Integer>> ans) {

        // Base case
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }
        
        // R.R
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);          
            solve(nums, index + 1, ans);
            swap(nums, i, index);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }

    public static void main(String[] args) {     
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result = permute(nums1);
        System.out.println("Permutations of [1, 2, 3]:");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
        
        System.out.println();
    }
}
