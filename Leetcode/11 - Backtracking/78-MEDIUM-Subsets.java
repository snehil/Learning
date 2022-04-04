// Problem - https://leetcode.com/problems/subsets/
// Explanation - https://www.youtube.com/watch?v=REOH22Xwdkk
// NOTE!       - *** Make a decision tree to be able to solve this problem!!
// Intuition - Draw a decision tree for this problem to see that it is a backtracking problem.
// 				Main gist is the you either pick the current element or not pick them (see below decision tree)

// Backtracking Intuition - 
//      Either pick the current element or don't pick it.
//              1. 
//            /. \
//           1.    [] 
//         / \      /.   \
//     [1,2]  [1]     [2]  [] 
//     /    \.  /. \.   /. \. / \
// [1,2,3][1,2] [1,3] [1] [2,3] [2] [3] []   
        
// TC: O(n * 2^n), as every element has two options-to pick or not pick and n bcz we are copying the list of size n in base case.
// SC: O(n * 2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        subsetsUtil(nums, result, new ArrayList<Integer>(), 0); 
        
        return result;
    }
    
    private void subsetsUtil(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
    	// Add list to the final result at the leaf
        if (start>= nums.length) { 
            res.add(new ArrayList<>(temp));
            return;        
        }
        
        // include
        temp.add(nums[start]);
        subsetsUtil(nums, res, temp, start+1);

        //exclude
        temp.remove(temp.size()-1); // remove last element
        subsetsUtil(nums, res, temp, start+1);
    }
}

