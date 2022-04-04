// Problem - https://leetcode.com/problems/clone-graph/
// Explanation - https://leetcode.com/problems/clone-graph/discuss/1793436/Java-Simple-Code-With-Heavy-Comments-(No-HashMap)

// Notes: Be creaful! - with line#39 and 47

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        Node copy = new Node(node.val);
        dfs(node, copy, visited);
        return copy;
    }
    
    private void dfs(Node node, Node copy , Node[] visited) {
        if (node==null) return;

        visited[copy.val] = copy;
        
        for (Node neighbor: node.neighbors) {
            if (visited[neighbor.val]==null) {
                Node copiedNeighborNode = new Node(neighbor.val);
                copy.neighbors.add(copiedNeighborNode);
                dfs(neighbor, copiedNeighborNode, visited);   
            } else {
                copy.neighbors.add(visited[neighbor.val]);
            }
        }
    }
}