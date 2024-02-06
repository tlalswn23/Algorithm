import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            queue.add(scoville[i]);
        }
        
        while(true){
            int soc = queue.poll();
            if(soc >= K){
                break;
            }
            
            if(queue.isEmpty()){
                answer = -1;
                break;
            }
            
            int soc2 = queue.poll();
            queue.add(soc+(soc2*2));
            answer++;
        }
        
        return answer;
    }
}