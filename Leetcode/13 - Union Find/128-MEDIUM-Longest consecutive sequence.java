// Problem - Longest consecutive sequence
// Note - This problem can also be solved using stack. Check Leetcode discuss section for more details.

class Solution {
    class UnionFind {
        private int[] parent;
        private int[] size;
        private int connectedComponents;
        private int capacity;
        
        public UnionFind(int capacity) {
            this.capacity = capacity;
            parent = new int[capacity];
            size = new int[capacity];
            connectedComponents = capacity;
            
            // Initialize arrays
            for (int i=0; i<capacity; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int getConnectedComponentCount() {
            return connectedComponents;
        }
        
        public int getLargestConnectedComponentSize() {
            if (size.length==0) return 0;
            
            int max = size[0];
            
            for (int i=1;i<size.length;i++) {
                max=Math.max(max, size[i]);
            }
            
            return max;
        }
        
        public int find(int a) {
    //         if (a==parent[a]) {
    //             return a;
    //         }

    //         int root = a;

    //         while(root!=parent[root]) {
    //             root=parent[root];
    //         }

    //         while(a!=root) {
    //             int temp = parent[a];
    //             parent[a] = root;
    //             a = temp;
    //         }

            // return root;

            if (a==parent[a]) {
                return a;
            }

            return parent[a]=find(parent[a]);
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA==rootB) return;

            if (size[rootA]>size[rootB]) {
                parent[rootB] = rootA;
                size[rootA]+=size[rootB];
                size[rootB]=0;
            } else {
                parent[rootA] = rootB;
                size[rootB]+=size[rootA];
                size[rootA]=0;
            }

            connectedComponents-=1;
        }
    }
    
    public int longestConsecutive(int[] nums) {
       UnionFind uf = new UnionFind(nums.length);
        // Map val to index in nums
        Map<Integer, Integer> valToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (valToIndex.containsKey(nums[i])) {
                continue;
            }
            
            if (valToIndex.containsKey(nums[i] - 1)) {
                uf.union(i, valToIndex.get(nums[i] - 1));
            }
            
            if (valToIndex.containsKey(nums[i] + 1)) {
                uf.union(i, valToIndex.get(nums[i] + 1));
            }
            
            valToIndex.put(nums[i], i);
        }
        
        return uf.getLargestConnectedComponentSize();
    }
}