// Problem - https://leetcode.com/problems/number-of-provinces/
// Intuition - This is basically asking for the number of connected components in a UnionFind data structure.

class UnionFind {
    private int[] parent;
    private int[] size;
    private int connectedComponentCount;
    private int capacity;
    
    public UnionFind(int capacity) {
        this.capacity = capacity;
        parent = new int[capacity];
        size = new int[capacity];
        connectedComponentCount = capacity;
        
        // Initialize 
        for (int i=0; i<capacity; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int getConnectedComponentCount() {
        return connectedComponentCount;
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
        
        connectedComponentCount-=1;
    }
}   

class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length==0) return 0;
        
        UnionFind disjointSet = new UnionFind(Math.max(isConnected.length, isConnected[0].length));
        
        for (int row=0; row<isConnected.length; row++) {
            for(int col=0; col<isConnected[0].length; col++) {
                if (isConnected[row][col]==1) {
                    disjointSet.union(row, col);
                }
            }
        }
        
        return disjointSet.getConnectedComponentCount();
    }
}
