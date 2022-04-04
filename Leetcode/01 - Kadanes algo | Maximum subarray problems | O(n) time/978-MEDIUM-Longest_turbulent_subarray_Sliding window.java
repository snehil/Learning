// Problem -https://leetcode.com/problems/longest-turbulent-subarray/
// Explanation - https://leetcode.com/problems/longest-turbulent-subarray/solution/

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        
        if (len==0) return 0;
        if (len==1) return 1;
        
        
        int result=1;
        int anchor =0;
        
        for (int i=1;i<len;i++) {
            int sign = Integer.compare(arr[i-1], arr[i]);
            
            if (sign==0) {
                anchor=i;
            } else if (i==len-1 || sign * Integer.compare(arr[i], arr[i+1])!=-1) { 
                result = Math.max(result, i-anchor+1);
                anchor=i;
            } 
        }
        
        return result;
    }
}
