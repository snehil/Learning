// PRoblem - https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> result = new LinkedList<>();
        
        for (int[] slot: intervals) {
            if (result.isEmpty()) {
                result.add(slot);
                continue;
            } 
            
            int[] prevSlot = result.getLast();
            
            if (prevSlot[1]<slot[0]) {
                result.add(slot);
            }
            
            else {
                prevSlot[0] = Math.min(slot[0], prevSlot[0]);
                prevSlot[1] = Math.max(slot[1], prevSlot[1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}