// Problem Link: 
// https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1?page=1&sprint=a663236c31453b969852f9ea22507634&sprint=a663236c31453b969852f9ea22507634&sortBy=submissions

/*
Given an array arr[] of N non-negative integers representing the height of blocks. 
If width of each block is 1, compute how much water can be trapped between the blocks 
during the rainy season. 

Example:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
*/

class Solution{
    
    typedef long long ll;
    
    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        ll ans = 0;
        int left = 0, right = n-1;
        int maxLeft = 0, maxRight = 0;
        
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(arr[left] >= maxLeft){
                    maxLeft = arr[left];
                }
                else{
                    ans += maxLeft - arr[left];
                }
                left++;
            }
            else{
                if(arr[right] >= maxRight){
                    maxRight = arr[right];
                }
                else{
                    ans += maxRight - arr[right];
                }
                right--;
            }
        }
        
        return ans;
    }
};