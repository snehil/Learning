// Problem - https://leetcode.com/problems/permutations/submissions/
// Intuition - https://www.youtube.com/watch?v=f2ic2Rsc9pU
// Notes - Need to memorize this solution!! The idea is to swap elements as explained in the video.

// TC = O(n*n!), SC = O(N)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, result, 0);
        
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, int start) {
        if (start==nums.length) {
            List<Integer> list = new ArrayList<>();
            
            for (int num:nums) {
                list.add(num);
            }
            
            res.add(new ArrayList<>(list));
        } 
        
        for (int i=start; i<nums.length;i++) {
            swap(i, start, nums);
            backtrack(nums, res, start+1);
            swap(i, start, nums);
        }
    }
    
    private void swap(int a, int b, int[] nums) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}

// Partial decision tree for the first value (1). Similar logic applies to remaining
// elements in a for-loop
//
//                       1        ... (AND SIMILARLY DO THIS FOR REMAINING ELEMENTS)... 
//        /.                                                     \                        \ 
//       1, 2, 3  (swap 1 by 1)                             2, 1, 3 (swap 1 by 2)          3, 2, 1 (swap 1 by 3)
//          ^                                                  ^                              ^
//         /                \                              /              \                      /                  \
// 1, 2, 3 (swap 2 by 2)    1,3,2 (swap 2 by 3)   2,1,3 (swap 1 by 1)   2,3,1 (swap 1 by 3)   3,2,1(swap 2 by 2)   3,1,2(swap 1 by 2)
//    ^                      ^                     ^                     ^                     ^                    ^ 

          
