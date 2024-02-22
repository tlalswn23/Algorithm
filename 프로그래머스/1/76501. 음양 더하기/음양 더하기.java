import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i]){ // 참이면 
                answer += absolutes[i];
            }
            
            if(!signs[i]){
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}