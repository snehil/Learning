// Problem - https://leetcode.com/problems/degree-of-an-array/
// EXmplanation - https://www.youtube.com/watch?v=7wT5sFELf7Q
class Solution {
    public int findShortestSubArray(int[] nums) {
        int len= nums.length;
        
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> lowBounds = new HashMap<>();
        
        int result = Integer.MAX_VALUE;
        int degree = 0;
        
        for (int i=0;i<len;i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i],0)+1);
            int curDegreeForItem = counts.get(nums[i]);
            
            if (!lowBounds.containsKey(nums[i])) {
                lowBounds.put(nums[i], i);
            }
            
            if (curDegreeForItem > degree) {
                degree = curDegreeForItem;
                result = i-lowBounds.get(nums[i])+1;
            } else if (curDegreeForItem == degree) {
                result = Math.min(result, i-lowBounds.get(nums[i])+1);
            }
        }
        
        return result;
    }
}