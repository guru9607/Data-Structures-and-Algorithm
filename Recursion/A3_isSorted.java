package Recursion;

public class A3_isSorted {

    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;

        if (arr[index] > arr[index + 1]) return false;

        return isSorted(arr, index + 1);
    }

    static int getSum(int[] arr, int index){
        if(index == arr.length -1) return arr[index];
        return arr[index] +  getSum(arr, index + 1);
    }

    static int linearSearch(int[] arr, int index, int key){ 
        if(index == arr.length) return -1;  // base case for empty and end
        if(arr[index] == key) return index;

        return linearSearch(arr, index + 1, key);
    }

    static int binarySearch(int[] arr, int start, int end, int key){
        if(start > end) return -1;
        int mid = (start + end)/2;

        if(arr[mid] == key) return mid;
        else if(arr[mid] < key) return binarySearch(arr, mid + 1, end, key);
        else return binarySearch(arr, start, mid-1, key);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(isSorted(arr, 0)); 
        System.out.println(getSum(arr, 0)); 
        System.out.println(linearSearch(arr, 0, 3)); 
        System.out.println(binarySearch(arr, 0, arr.length-1, 5));
    }
}
