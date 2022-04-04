// Problem - https://leetcode.com/problems/course-schedule-ii/
// Intuition - This is based on the Kahn's Topological sort algorithm. https://www.youtube.com/watch?v=tggiFvaxjrY

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Initialize
        for (int i=0;i<numCourses; i++) {
            graph.put(i, new ArrayList<>());
            indegreeMap.put(i, 0);
        }
        
        // Populate values
        for (int[] prereq : prerequisites) {
            int source = prereq[1];
            int dest = prereq[0];
            
            graph.get(source).add(dest);
            indegreeMap.put(dest, indegreeMap.get(dest)+1);
        }
        
        // BFS 
        
        Queue<Integer> q = new LinkedList<>();
        
        indegreeMap.forEach((vertex, indegree)->{
            if (indegree==0) {
                q.add(vertex);
            }
        });
        
        while (!q.isEmpty()) {
            int vertex = q.poll();
            result.add(vertex);
            
            for (int neighbor: graph.get(vertex)) {
                indegreeMap.put(neighbor, indegreeMap.get(neighbor)-1);
                
                if (indegreeMap.get(neighbor)==0) {
                    q.add(neighbor);
                }
            }
        }
        
        return result.size()==numCourses 
            ? result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray()
            : new int[0];       
    }
}