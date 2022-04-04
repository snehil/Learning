// Kadane's algorithm - Have a running sum, keep track of max but set running sum to ZERO if it is negative.
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        
        if (len==0) return 0;
        
        int max = nums[0];
        int sum =0;
        
        for (int num:nums) {
            sum+=num;
            max = Math.max(max, sum);
            if (sum<0) sum=0; 
        }
        
        return max;
    }
}

// Explanation using DP - https://www.youtube.com/watch?v=tmakGVOGV3A
class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length==0) return 0;
        
        int maxVal = nums[0];
        
        // Kadene's algorithm
        for (int i=1; i<nums.length;i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        
        return maxVal;
        
    }
}

// Variant to find start and end indices
// Now here in this question you can see that you can also be asked some more things like :

// Length of the max subarray
// Elements of the max subarray
// Start and End index of max subarray

class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length==0) return 0;
        
        int maxVal = nums[0];
        int startIdx = 0;
        int endIdx = 0;
        
        // Kadene's algorithm
        for (int i=1; i<nums.length;i++) {
            
            if (nums[i]+nums[i-1] > nums[i]) {
                nums[i] = nums[i]+nums[i-1];
                
            } else {
                startIdx = i;
            }
            
            if (nums[i]>maxVal) {
                maxVal = nums[i];
                endIdx = i;
            }
        }
        
        System.out.println("Start Index = " + startIdx);
        System.out.println("End Index = " + endIdx);
        
        return maxVal;
        
    }
}