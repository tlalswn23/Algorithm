import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[speeds.length];
        
        int index = 1;
        int max = (int)Math.ceil((double)(100-progresses[0])/speeds[0]);
        int idx = 0;
        int count = 1;
      
        while(index < progresses.length){
            int days = (int)Math.ceil((double)(100-progresses[index])/speeds[index]);

            if(days > max){ // 선 작업 마칠때까지 완성되지 못하면
                answer[idx] = count; // 이전 작업 저장
                max = days; // max 갱신 
                idx++;
                index++;
                count = 1;
            }else{ // 기간 안에 완성할 수 있으면 
                count++;
                index++;
            }
        }
        
        answer[idx] = count;
        
        return Arrays.copyOfRange(answer, 0, idx+1);
    }
}