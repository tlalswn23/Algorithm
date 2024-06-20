import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> word = new HashSet<>();
        
        for(int i = 0; i < skip.length(); i++){
            word.add(skip.charAt(i));
        }
        
        for(int i = 0; i < s.length(); i++){
            char start = s.charAt(i);
            char result = start;
            int cnt = 0;
            int size = index;
            
            while(cnt <= size){
                result = (char)(start + cnt);
                
                if(result == (char)('z'+1)){
                    size = size - cnt;
                    cnt = 0;
                    start = 'a';
                    result = 'a';
                }
                
                if(word.contains(result)){
                    size++;
                }
                
                cnt++;
            }
            
            answer += result;
        }
        
        return answer;
    }
}