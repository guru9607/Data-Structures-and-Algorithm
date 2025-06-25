// https://leetcode.com/problems/sort-colors/

class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    ================================================================================
    ✅ Brute Force – Simple Bubble Sort (Only works for small inputs)
    ================================================================================

    🔍 Intuition:
    - We sort the array using bubble sort-like nested loops.
    - For every element, compare it with the next ones and swap if out of order.

    🔁 Time: O(n^2)
    📦 Space: O(1)
    */
    public void sortColorsBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    /*
    ================================================================================
    ✅ Better – Counting Sort Inspired (2-pass solution)
    ================================================================================

    🔍 Intuition:
    - Count how many 0s, 1s, and 2s exist.
    - Then overwrite the array using those counts.

    🔁 Time: O(2n)
    📦 Space: O(1)
    */
    public void sortColorsBetter(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) num0++;
            else if (nums[i] == 1) num1++;
            else num2++;
        }

        int i = 0;
        while (num0-- > 0) nums[i++] = 0;
        while (num1-- > 0) nums[i++] = 1;
        while (num2-- > 0) nums[i++] = 2;
    }

    /*
    ================================================================================
    ✅ Optimal – Dutch National Flag Algorithm (1-pass solution)
    ================================================================================

    🔍 Intuition:
    - We maintain three regions:
        - [0..low-1] =>  0s
        - [low..mid-1] => 1s
        - [mid...high] => unknown processing zone
        - [high+1..end] => 2s
    - Traverse with mid pointer and sort elements in-place:
        - If nums[mid] == 0 ..... swap with low, move both
        - If nums[mid] == 1 ..... just move mid
        - If nums[mid] == 2 ...... swap with high, move high only

    🔁 Time: O(n)
    📦 Space: O(1)
    */
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}
