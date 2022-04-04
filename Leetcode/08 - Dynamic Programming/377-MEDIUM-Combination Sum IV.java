// Problem - https://leetcode.com/problems/combination-sum-iv/
// Explanation - https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation

// TC = O(N^target.length), SC = O(target.length)
// Top-down DP
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return helper(nums, target, dp);
    }
    
    private int helper(int[] nums, int target, int[] dp) {
        if (dp[target]!=-1) {
            return dp[target];
        }
        
        if (target==0) return 1;
        
        int result = 0;
        
        for (int i=0;i<nums.length;i++) {
            if (target>=nums[i]) {
                result += helper(nums, target-nums[i], dp);
            }
        }
        
        dp[target] = result;
        
        return result;
    }
}

