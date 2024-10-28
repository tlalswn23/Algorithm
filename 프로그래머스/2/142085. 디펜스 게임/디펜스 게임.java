import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1); // 병사를 많이 소모한 순
        int index = 0;

        for(int i = 0; i < enemy.length; i++){
            boolean check = false;
            
            while(n < enemy[i]){ // 적이 더 많고 
                if(k > 0){ // 무적권이 남아있다면 
                    if(!max.isEmpty() && max.peek() >= enemy[i]){ // 무적권을 사용할 수 있는 이전 라운드가 있으면
                        n += max.poll();
                        k--;
                    }else{ // 현재 라운드에 무적권 사용
                        k--;
                        check = true;
                        break;
                    }
                    continue;
                }
                break;
            }
            
            if(check){ // 현재 라운드에 무적권을 사용했으면
                answer++;
                continue;
            }
            
            if(n < enemy[i]){
                break;
            }
            
            // 병사가 더 많으면 
            n -= enemy[i];
            max.add(enemy[i]); // 현재 라운드에 사용했으면 들어가면 안됨    
            answer++;
        }
        
        return answer;
    }
}