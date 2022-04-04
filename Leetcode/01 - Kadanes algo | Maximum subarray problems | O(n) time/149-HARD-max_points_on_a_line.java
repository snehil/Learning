// Leetcode 149 [HARD] - Max points on a line 
// Problem             - https://leetcode.com/problems/max-points-on-a-line/
// Explanation         - https://www.youtube.com/watch?v=DCbPOZTNfHc
class Solution {
    private int gcd(int a, int b) {        
        return (b==0) ? a : gcd(b, a%b);
    }
    
    public int maxPoints(int[][] points) {
        if (points.length ==0) return 0;
        
        int maxSlope = 0;

        for (int i=0;i<points.length;i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int dup = 0;

            for (int j=i;j<points.length;j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                
                if (dy==0 && dx==0) {
                    dup++;
                } else {
                    int gcd = gcd(dy,dx);

                    dy/=gcd;
                    dx/=gcd;

                    String slope = String.valueOf(dy)+'_'+String.valueOf(dx);
                    Integer curSlope = slopeCount.getOrDefault(slope, 1);
                    slopeCount.put(slope, curSlope+1);   
                }
            }
            
            maxSlope = Math.max(maxSlope, dup);
            
            for (Map.Entry<String, Integer> entry : slopeCount.entrySet()) {
                String slope = entry.getKey();
                Integer count = entry.getValue();
                
                maxSlope = Math.max(maxSlope, slopeCount.get(slope));
            }
        }
        
        return maxSlope;
    }
}