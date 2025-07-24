package Recursion;

public class A6_MergeSort {
    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;

        int mid = start + (end-start) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;     // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = 0;         // pointer for temp array

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // Copy remaining elements from left side (if any)
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // Copy remaining elements from right side (if any)
        while (j <= end) {
            temp[k++] = array[j++];
        }

        // Copy back to original array
        for (int p = 0; p < temp.length; p++) {
            array[start + p] = temp[p];
        }
    }

    
    public static void main(String[] args) {
        
    }
}
