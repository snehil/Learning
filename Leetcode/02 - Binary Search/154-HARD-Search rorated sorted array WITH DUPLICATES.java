// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48908/Clean-python-solution
class Solution {
    public int findMin(int[] nums) {
        if (nums.length==0) return 0;
    
        int left=0;
        int right=nums.length-1;
        
        while (left<right) {
            int mid = left + (right-left)/2;
        
            if (nums[mid]>nums[right]) {
                left = mid+1;
            } else {
                right = nums[right] != nums[mid] ? mid : right-1;
            }     
        }
        
        return nums[right];
    }
}