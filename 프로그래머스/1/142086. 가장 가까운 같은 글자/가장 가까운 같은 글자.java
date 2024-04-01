import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            answer[i] = -1;
        }
        
        for(int i = s.length()-1; i >= 0; i--){
            int cnt = 1;
            for(int j = i-1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    answer[i] = cnt;
                    break;
                }
                cnt++;
            }
        }
        
        return answer;
    }
}