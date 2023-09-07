import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int temp : tangerine){
            if(count.containsKey(temp)){
                count.put(temp, count.get(temp)+1);
                continue;
            }
            count.put(temp, 1);
        }
        
        List<Integer> list = new ArrayList<>(count.values());
        list.sort((o1, o2) -> o2.compareTo(o1));
        
        for(int i : list){
            k -= i;
            answer++;
            
            if(k <= 0){
                break;
            }
        }
        
        return answer;
    }
}

// 가장 많은 거부터 몇 개 있는지 개수만 알면 됨 