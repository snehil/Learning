// Problem - https://leetcode.com/problems/subsets-ii/
// Intuition - https://www.youtube.com/watch?v=Vn2v6ajA7U0
// NOTE!       - *** Make a decision tree to be able to solve this problem!!

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        subsetsUtil(nums, result, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void subsetsUtil(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        
        if (start>=nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        // Include 
        temp.add(nums[start]);
        subsetsUtil(nums, res, temp, start+1);
        
        // Exclude
        temp.remove(temp.size()-1);
        
        // Skip duplicates
        while(start<nums.length-1 && nums[start]==nums[start+1]) {
            start+=1;
        }
        
        subsetsUtil(nums, res, temp, start+1);
    }
    
}