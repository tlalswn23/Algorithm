import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> dishes = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            dishes.add(scoville[i]);
        }
        
        while(dishes.size() > 1){
            int d1 = dishes.poll();
            int d2 = dishes.poll();
            int nd = d1 + (d2 * 2);
            
            if(d1 >= K){ // 가장 작은 값이 K보다 크면 모든 값이 K이상이므로 멈춤
                break;
            }
            
            dishes.add(nd);
            answer++;
        }
        
        if(!dishes.isEmpty()){
            int last = dishes.poll();
            if(last < K){
                return -1;
            }
        }
        return answer;
    }
}