import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i = 0; i < works.length; i++){
            queue.add(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            int num = queue.poll();
            queue.add(num-1);
        }
        
        for(int i = 0; i < works.length; i++){
            int num = queue.poll();
            if(num < 0){
                break;
            }
            answer = answer + num * num;
        }
        
        return answer;
    }
}