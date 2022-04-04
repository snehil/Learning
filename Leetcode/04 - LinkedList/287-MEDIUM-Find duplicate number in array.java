// Problem - https://leetcode.com/problems/find-the-duplicate-number/
// Intuition: https://leetcode.com/problems/find-the-duplicate-number/solution/
// 2 methods - Negative marking and Floyd Cycle detection algorithm (fast and slow pointer)
// NOTE: XOR solution does not work here! It can only be used to find a sigle non-duplicate number in an array. (540-MEDIUM-https://leetcode.com/problems/single-element-in-a-sorted-array/)

// Method 1: Floyd cycle detection. O(n) time, O(1) space. This is based on Linlikst Cycle II problem (142-MEDIUM).
    public int findDuplicate(int[] nums) {
        if (nums.length==0) return -1;
        
        int fast = nums[0];
        int slow = nums[0];
        
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } 
        while (fast!=slow);
        
        slow = nums[0];
        
        while (fast!=slow) {
            fast=nums[fast];
            slow=nums[slow];
        }
    
        return fast;
    }


// Method 2: Negative marking (A good technique to know!). O(n) time, O(1) space but modifies the array (if allowed)
// Intuition: https://leetcode.com/problems/find-the-duplicate-number/solution/
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length==0) return -1;
        
        for (int i=0;i<nums.length;i++) {
            int idx = Math.abs(nums[i])-1;
            
            if (nums[idx]<0) {
                return idx+1;
            }
            
            nums[idx]*=-1;
        }
        
        return -1;
    }
}
