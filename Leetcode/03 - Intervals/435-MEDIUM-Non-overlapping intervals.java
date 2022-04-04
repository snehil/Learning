// Problem - https://leetcode.com/problems/non-overlapping-intervals/
// Intuition: https://www.youtube.com/watch?v=BTObFnHbD4U
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int left = 0;
        int right = 1;
        int count = 0;
        
        while (right<intervals.length) {
            // no overlap
            if (intervals[left][1] <= intervals[right][0]) {
                left = right;
                right+=1;
            }
            
            // skip right
            else if (intervals[left][1] <= intervals[right][1]) {
                right+=1;
                count+=1;
            }
            
            else if (intervals[left][0] <= intervals[right][0] && intervals[left][1] >= intervals[right][1]) {
                left=right;
                right+=1;
                count+=1;
            }
        }
        
        return count;
    }
}
