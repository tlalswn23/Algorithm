import java.util.*;

class Solution {
    static int M;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        M = times.length; 
        
        long right = Long.MAX_VALUE / 100;
        long left = times[0];
        long mid = 0;
        
        while(left < right){
            mid = (right + left) / 2;
            long cnt = checkCount(mid, times);
            
            if(cnt >= n){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    static long checkCount(long time, int[] times){
        long count = 0;
        
        for(int i = 0; i < M; i++){
            count += time / (long)times[i];
        }
        
        return count;
    }
}