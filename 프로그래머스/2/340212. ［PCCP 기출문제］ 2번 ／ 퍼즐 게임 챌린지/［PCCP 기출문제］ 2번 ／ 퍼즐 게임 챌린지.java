import java.util.*;

class Solution {
    static int max, min;
    
    public int solution(int[] diffs, int[] times, long limit) {
        min = 100000;
        
        // 이분탐색 구간 구하기 
        for(int i = 0; i < diffs.length; i++){
            max = Math.max(max, diffs[i]);
            min = Math.min(min, diffs[i]);
        }
        
        int answer = max;
        
        if(min == max){
            return answer;
        }
        
        while(min < max){
            int mid = (max + min) / 2;
            
            if(canSolve(mid, diffs, times, limit)){ // 해결할 수 있으면 
                max = mid;
                answer = Math.min(answer, mid);
            }
            else{
                // 해결할 수 없으면
                min = mid+1;
            }
        }
        
        return answer;
    }
    
    // 문제를 해결할 수 있는지 확인하는 함수
    static boolean canSolve(int level, int[] diffs, int[] times, long limit){
        long time = 0;
        int time_cur = 0;
        int time_prev = 0;
        
        for(int i = 0; i < diffs.length; i++){
            time_cur = times[i];
            
            // 1. diff <= level
            if(diffs[i] <= level){
                time += time_cur;
            }
            
            // 2. diff > level
            else{
                time = time + (diffs[i] - level) * time_cur
                    + (diffs[i] - level) * time_prev
                    + time_cur;
            }
            
            time_prev = time_cur;
        }
        
        if(time <= limit){
            return true;
        }
        
        return false;
    }
}