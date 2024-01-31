// Problem Link : 
// https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?page=1&sprint=a663236c31453b969852f9ea22507634&sprint=a663236c31453b969852f9ea22507634&sortBy=submissions

/*
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
*/

class Solution{
  public:
    
    typedef long long ll;
    ll ans = 0;
    
    long long int inversionCount(long long arr[], long long N)
    {
        ans = 0;
        mergeSort(arr, 0, N-1);
        return ans;
    }
    
    void mergeSort(ll arr[], ll low, ll high)
    {
        if(low < high){
            ll mid = low + (high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    
    void merge(ll arr[], ll low, ll mid, ll high)
    {
        ll n1 = mid-low +1, n2 = high - mid;
        ll arr1[n1], arr2[n2];
        
        for(ll i=0; i<n1; i++) arr1[i] = arr[low+i];
        for(ll i=0; i<n2; i++) arr2[i] = arr[mid+i+1];
        
        ll i=0, j=0, k=low;
        
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]) arr[k++] = arr1[i++];
            else{
                ans+= n1 - i; // When the else condition is triggered in the merge step, it means that there are inversions between the element arr2[j] and all the remaining elements in the first half arr1[i] up to the end (n1).
                arr[k++] = arr2[j++];
            }
        }
        while(i<n1) arr[k++] = arr1[i++];
        while(i<n2) arr[k++] = arr2[j++];
    }

};