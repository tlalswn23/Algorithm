import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n = p.length();
        int right = n - 1;
        String num = "";
        long pNum = Long.parseLong(p);
        
        for(int i = 0; i < n; i++){
            num += t.charAt(i);
        }
        
        if(Long.parseLong(num) <= pNum){
            answer++;
        }
        
        right++;
        
        while(right < t.length()){
            
            num += t.charAt(right);
            num = num.substring(1);
            
            if(Long.parseLong(num) <= pNum){
                answer++; 
            }
            
            right++;
        }
        
        return answer;
    }
}