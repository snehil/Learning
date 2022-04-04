// Problem - https://leetcode.com/problems/top-k-frequent-elements/
// Intuition - https://www.youtube.com/watch?v=YPTqKIgVk-k

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        
        if (len==0) return new int[0];
        
        ArrayList<Integer>[] buckets = new ArrayList[len];
        
        Map<Integer, Integer> valueToFreq = new HashMap<>();
        
        for (int num:nums) {
            valueToFreq.put(num, valueToFreq.getOrDefault(num, 0) + 1);
        }
                
        for (Map.Entry<Integer, Integer> entry: valueToFreq.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            
            if (buckets[freq-1]==null) {
                buckets[freq-1] = new ArrayList<>();
                
            } 
            
            buckets[freq-1].add(value);
        }
        
        int count = 0;
        
        List<Integer> result = new ArrayList<>();
        
        for (int i=len-1; i>=0; i--) {
            if (buckets[i]==null) continue;
                        
            for (Integer item: buckets[i]) {
                count+=1;
                
                if (count>k) {
                    break;
                }
                
                result.add(item);
            }
        }
        
        return result
            .stream()
            .mapToInt(i->i)
            .toArray();
    }
}