// Problem - https://leetcode.com/problems/course-schedule/
// Intuition - This is a Kahn's algorithm implementation example - https://www.youtube.com/watch?v=tggiFvaxjrY
// Notes - Be careful on how to initialize the graph and indegreeMap using the NUMCOURSES variable and not by
// 			the size of prerequisites. The number of removed nodes from the queue (BFS) should be the same as
// 			the total number of courses to get complete topological sort ordering (and hence the answer on whether
//			all the courses can be taken with the prerequisites)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        int removedNodes = 0;
        
        // Initialize
        for (int i=0;i<numCourses;i++) {
            graph.put(i, new ArrayList<>());
            indegreeMap.put(i, 0);
        }
        
        // Populate values
        for (int[] prereq: prerequisites) {
            int source=prereq[1];
            int dest=prereq[0];
            graph.get(source).add(dest);
            indegreeMap.put(dest, indegreeMap.get(dest)+1);
        }
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Add nodes with ZERO indegree to the Queue
        indegreeMap.forEach((vertex, indegree) -> {
            if (indegree==0) {
                q.add(vertex);
            }
        });
        
        while(!q.isEmpty()) {
            int vertex = q.poll();
            removedNodes+=1;
            
            for (int neighbor:graph.get(vertex)) {
                indegreeMap.put(neighbor, indegreeMap.get(neighbor)-1);
                
                if (indegreeMap.get(neighbor)==0) {
                    q.add(neighbor);
                }
            }
        }
        
        return removedNodes==numCourses;
    }
}