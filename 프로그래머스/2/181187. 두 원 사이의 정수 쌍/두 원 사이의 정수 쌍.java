import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i <= r2; i++){
            double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            
            answer += ((long)y2 - (long)Math.ceil(y1) + 1);
        } 
        
        return answer * 4;
    }
}