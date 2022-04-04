// Problem - https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==0) return -1;
        int xxor = nums[0];
        
        for (int i=1;i<nums.length;i++) {
            xxor^=nums[i];
        }
        
        return xxor;
    }
}