import java.util.*;

class Solution {
    static Queue<Integer> bridge;
    static int[] distance; // 각 트럭이 이동한 거리 
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0; // 다리 위 트럭의 총 무게
        int arrive = 0; // 내려간 트럭의 수
        int index = 0;
        bridge = new LinkedList<>();
        distance = new int[truck_weights.length];
        
        // 모든 트럭이 다 내려갔으면 종료 
        while(arrive < truck_weights.length){
            
            // 1. 끝에 도달한 트럭 내리기
            if(!bridge.isEmpty()){
                int truck = bridge.peek();
                if(distance[arrive] == bridge_length){ // 끝에 도달했으면
                    bridge.poll(); // 내리기
                    sum -= truck;
                    arrive++;
                }
            }
            
            // 2. 다음 트럭 올리기 
            if(index < truck_weights.length && bridge.size() < bridge_length && sum < weight){
                int next = truck_weights[index];
                if(sum+next <= weight){
                    bridge.add(next);
                    sum += next;
                    index++;
                }
            }
            
            // 3. 1초++
            for(int i = arrive; i < index; i++){
                distance[i]++;
            }
            
            answer++;
        }
        
        return answer;
    }
}