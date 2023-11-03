import java.util.*;

class Solution {
    static int[] arr;
    
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left) + 1];
        
        for (int i = 0; i < answer.length; i++) {
            int x = ((int)(left % n) + 1);
            int y = ((int)(left / n) + 1);
            
            answer[i] = Math.max(y, x);
            left++;
        }
        
        return answer;
    }
}