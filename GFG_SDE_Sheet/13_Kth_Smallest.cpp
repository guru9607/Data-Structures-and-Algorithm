// https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1?page=1&sprint=a663236c31453b969852f9ea22507634&sprint=a663236c31453b969852f9ea22507634&sortBy=submissions

/*
Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Note :-  l and r denotes the starting and ending index of the array.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
L=0 R=5

Output : 7
Explanation :
3rd smallest element in the given 
array is 7.

Example 2:

Input:
N = 5
arr[] = 7 10 4 20 15
K = 4 L=0 R=4
Output : 15
Explanation :
4th smallest element in the given 
array is 15.
*/

class Solution{
    public:
    int kthSmallest(int arr[], int l, int r, int k) {
        
        sort(arr + l , arr + r + 1);
        return arr[l + k -1 ];
    }
};