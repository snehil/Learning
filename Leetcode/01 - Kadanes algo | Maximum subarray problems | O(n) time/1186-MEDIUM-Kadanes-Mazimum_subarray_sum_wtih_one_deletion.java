// Problem - https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

// 2 methods
// Method 1: Kadane's algorithm - Explanation: https://www.youtube.com/watch?v=9JOLjBF4RFs
//     1 forward iteration of Kadane's algo to find forward max values, 1 backward iteration of the Kadane's algorithm to find backward max values. Then loop through
//     each element from left to right to calculate and keep track of the max value for the following -> max[i] = forward[i-1]+backward[i+1]

// Method 2: DP, Explanation: https://www.youtube.com/watch?v=s8WQNn0h5i4
//     either consider no deletion, or a single deletion (prev or current value), or ignore all previous value and start fresh from current value. Take the max of all of these values to get answer. 



// METHOD-1
// Explanation - https://www.youtube.com/watch?v=s8WQNn0h5i4
// Intuition - Find max sum for each element i using Kadane's algorithm (both forward and backward). 
// To find result for each 'i' after 1 deletion, iterate through the array and for each i, add forward[i-1]+backward[i+1].
// The max value from the above computation is the answer.
class Solution {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        
        if (len==0) return 0;
                
        // forward
        int[] forward = new int[len];
        int max = arr[0];
        forward[0] = arr[0];
        
        // Kadane's algo [DP]
        for (int i=1;i<len;i++) {
            forward[i] = Math.max(arr[i], forward[i-1]+arr[i]);
            max = Math.max(max, forward[i]);
        }
        
        // backward
        int[] backward = new int[len];
        backward[len-1] =arr[len-1];
        
        for (int i=len-2;i>=0;i--) {
            backward[i] = Math.max(arr[i], arr[i] + backward[i+1]);
        }
        
        // find max
        for (int i=1;i<len-1;i++) {
            max = Math.max(max, forward[i-1]+backward[i+1]);
        }
        
        return max;
    }
}

// METHOD-2: Dynamic Programming
// Explanation: https://www.youtube.com/watch?v=s8WQNn0h5i4
// Intuition:
//     Conditions for DP while iterating each item in the given array:
//          1. both (current item and previous subarray no delete)
//          2. start from current item (disregard previous subarray)
//          3. skip current item AND assume previous subarray has NO delete
//          4. assume previous subarray has a delete AND keep the current item
class Solution {
    public int maximumSum(int[] arr) {
        int len=arr.length;
        
        if (len==0) return 0;
                
        int leftNoDelete = arr[0];
        int leftWithDelete = 0;
        int max = arr[0];
        
        for (int i=1;i<len;i++) {
            leftWithDelete = Math.max(leftWithDelete+arr[i], leftNoDelete); 
            leftNoDelete = Math.max(leftNoDelete+arr[i], arr[i]);
            int current = Math.max(leftNoDelete, leftWithDelete);
            max = Math.max(max, current);
        }
         
        return max;
    }
}


