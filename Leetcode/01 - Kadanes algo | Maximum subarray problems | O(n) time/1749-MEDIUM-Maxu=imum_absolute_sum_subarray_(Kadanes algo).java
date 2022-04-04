// Problem - https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
class Solution {
    // METHOD-1:Prefix sum
    // Intuition - Find the running sum and keep track of max and min sums. Result is max-min. 
    public int maxAbsoluteSum(int[] nums) {
        int min = 0;
        int max = 0;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        
        return max - min;
    }
    
    // METHOD-2:Kadane's algorithm
    // Intuition - Use Kadane's algo to find max and min sums separately. Result is the MAX of the absolute values of the max and min values found.
    public int maxAbsoluteSum(int[] nums) {   
        int len = nums.length;
        
        if (len==0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        // Find Max sum using Kadane's algo
        for (int i=0;i<len;i++) {
            sum+=nums[i];
            max=Math.max(max, sum);
            if (sum<0) sum=0;
        }
        
        sum=0;

        // Find Min sum using Kadane's algo
        for (int i=0;i<len;i++) {
            sum+=nums[i];
            min=Math.min(min, sum);
            if (sum>0) sum=0;
        }
        
        return Math.max(Math.abs(max), Math.abs(min));
    }
}
