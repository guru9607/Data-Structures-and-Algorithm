package Recursion;

import static Recursion.Utils.swap;

import java.util.Arrays;





public class A5_BubbleSort {

    // Round i => ith largest element => (n-i) position pe pohoch jayega

    // Bubble Sort: Sorts the array in ascending order by repeatedly swapping adjacent elements if they are in the wrong order
    // TC: O(n^2) worst case, O(n) best case (with early exit using 'swapped')
    // SC: O(1) — In-place sorting
    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            
            // swapped flag helps optimize: if no swap in a pass, array is already sorted
            boolean swapped = false;

            // Inner loop compares adjacent pairs and pushes largest to the right end
            for(int j = 0; j < n - 1 - i; j++){

                // If current element is greater than next, swap them
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    swapped = true; // Mark that a swap happened
                }
            }

            // Optimization: if no swaps in entire inner loop, array is sorted, break early
            if(!swapped){
                break; // Already sorted
            }
        }
    }

    // Using Recursion 
    static void bubbleSortRecursive(int[] arr, int n){
        //base case
        if(n == 0 || n == 1) return;

        // ek case solve karliya, larget element ko end pe rakh degA
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                swapped = true;
            }
        }
        if (!swapped) return;

        bubbleSortRecursive(arr, n-1);
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,4,5};

        bubbleSortRecursive(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
