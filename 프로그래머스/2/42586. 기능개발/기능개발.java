import java.util.*;

class Solution {
    static Queue<Integer> queue;
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.add((int)Math.ceil((double)(100-progresses[i])/speeds[i])); // 올림해서 날짜 측정
        }
        
        int max = queue.poll();
        int func = 1; // 기능 개수
        int cnt = 0; // answer 크기
        while(!queue.isEmpty()){
            int day = queue.poll();
            
            if(max < day){
                answer[cnt] = func;
                max = day;
                cnt++;
                func = 1;
                continue;
            }
            
            func++;
        }
        
        answer[cnt] = func;
        
        return Arrays.copyOfRange(answer, 0, cnt+1);
    }
}