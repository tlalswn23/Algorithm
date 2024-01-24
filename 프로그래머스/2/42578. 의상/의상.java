import java.util.*;

class Solution {
    static Map<String, Integer> map;
    
    public int solution(String[][] clothes) {
        int answer = 1;
        map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];
            int cnt = 0;
            
            if(map.containsKey(key)){ // 포함하고 있으면
                cnt = map.get(key);
            }
               
            map.put(key, cnt+1);
        }
        
        // 포함하지 않는 경우 +1 해서 경우의 수 구하기 
        for(String s : map.keySet()){
            int cnt = map.get(s);
            answer *= (cnt+1);
        }
        
        return answer -1; // 아무것도 포함하지 않는 경우 한 개 빼기 
    }
}