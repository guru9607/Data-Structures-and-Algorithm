// https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1?page=1&sprint=a663236c31453b969852f9ea22507634&sprint=a663236c31453b969852f9ea22507634&sortBy=submissions

/*
Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as 
{1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}. 
The difference between 
the largest and the smallest is 8-3 = 5.
Example 2:

Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}. 
The difference between 
the largest and the smallest is 17-6 = 11. 
*/

class Solution {
  public:
    int getMinDiff(int arr[], int n, int k) {
        // code here
        sort(arr, arr + n);
        int mini = arr[0];
        int maxi = arr[n-1];
        int ans = maxi - mini;
        
        for(int i = 1; i < n; i++){
            int a = arr[i-1] + k;
            int b = arr[i] - k;
            
            if(b < 0) continue;
            
            maxi = max(arr[n-1] - k, a);
            mini = min(arr[0] + k, b);
            ans = min(ans, maxi - mini);
        }
        
        return ans;
    }
};