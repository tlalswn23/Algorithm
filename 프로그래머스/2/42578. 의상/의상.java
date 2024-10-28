import java.util.*;

class Solution {
    
    static Map<String, Integer> type; // 의상 종류에 따른 개수
    static boolean[] visited;
    static int answer = 1;
    
    public int solution(String[][] clothes) {
        type = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String[] temp = clothes[i];
            int cnt = 0;
            
            if(type.containsKey(temp[1])){
                cnt = type.get(temp[1]);
            }
            
            type.put(temp[1], cnt+1);
        }
        
        
        for(Integer n : type.values()){
            answer *= (n+1); 
        }
        
        return answer-1;
    }
}