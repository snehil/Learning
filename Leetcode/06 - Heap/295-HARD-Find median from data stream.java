// Problem: https://leetcode.com/problems/find-median-from-data-stream/
// Explanation: https://leetcode.com/problems/find-median-from-data-stream/discuss/1330646/C%2B%2BJavaPython-MinHeap-MaxHeap-Solution-Picture-explain-Clean-and-Concise
// Idea is that the median is always the middle number of a sorted list. So we can use 2 heaps (min and max) to keep track of the
// sorted list (2 halves) and then find the median by peeking the top of the respective heaps (for even, it is an average value of
// both while for odd, it is the peek value from the max heap)

class MedianFinder {
    private PriorityQueue<Integer> minHeap; // top half of sorted list
    private PriorityQueue<Integer> maxHeap; // bottom half of sorted list 
    
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        // Rebalance if needed
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {        
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

