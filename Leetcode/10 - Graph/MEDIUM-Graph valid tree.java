// Problem - https://leetcode.com/problems/graph-valid-tree/
//			- https://www.lintcode.com/problem/178/description
// Explanation - https://www.youtube.com/watch?v=rFf4mXWbb9U
// Notes - This can also be solved via union find. 2 things need to be checked, does the graph have a cycle and 
// 			if the number of nodes visited after DFS is the same as the given node count. If not, it is not a valid graph tree.

//         We can either use BFS or DFS. For every vertex 'v', if there is an adjacent vertex 'u' such that it is already 
//			visited and is not a parent of 'v', then there is a cycle in the graph. If we don't find such an adjacent vertex
//  		for any vertex, we say that there is no cycle.

// UNCHECKED DFS-ITERATIVE CODE! (PREMIUM PROBEM!!)

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        return dfs(n, buildGraph(edges));
    }

    private boolean dfs(int n, Map<Integer, List<Integer>> graph) {
        if (n==0 || n!=graph.size()) return false;

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        Map.Entry<Integer, List<Integer>> first = graph.entryset().iterator().next();
        stack.push(first.getKey());
        int parent = first;

        while(!stack.isEmpty()) {
            Integer vertex = stack.pop();
            visited[vertex] = true;

            for (int neighbor:graph.get(vertex)) {
                if (!visited[neighbor] && neighbor!= parent) {
                    stack.push(neighbor);
                    parent=neighbor;
                }
            }
        }

        int count = 0;

        for (int i=0;i<visited.length;i++) {
            if (visited[i]) count+=1;
        }

        return count+1==n;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize
        for (int[] edge: edges) {
            int source = edge[1];
            int dest = edge[0];
            
            if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
            if (!graph.containsKey(dest)) graph.put(dest, new ArrayList<>());
        
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }

        return graph;
    }
}