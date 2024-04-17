import java.util.*;

class Solution {
    static Deque<String> cache;
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        cache = new ArrayDeque<>();
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if(cache.contains(city)){
                cache.remove(city); // 지우고
                cache.addFirst(city); // 맨 앞에 삽입
                answer++;
                continue;
            }
            
            if(cache.size() < cacheSize){
                cache.addFirst(city);
                answer += 5;
                continue;
            }
            
            cache.addFirst(city); // 맨앞에 삽입
            cache.removeLast(); // 마지막 삭제
            answer += 5;
        }
        
        return answer;
    }
}