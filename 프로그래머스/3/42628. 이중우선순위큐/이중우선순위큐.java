import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++){
            String[] command = operations[i].split(" ");
            if(command[0].equals("I")){
                int num = Integer.parseInt(command[1]);
                queue.add(num);
            }else{ // D 명령어면 
                
                if(queue.isEmpty()){
                    continue;
                }
                
                int type = Integer.parseInt(command[1]);
                if(type == -1){ // 최소값
                    queue.poll();
                }
                
                if(type == 1){ // 최대값
                    PriorityQueue<Integer> reverse = new PriorityQueue<>((o1, o2)-> o2-o1);
                    reverse.addAll(queue);
                    reverse.poll();
                    queue.clear();
                    queue.addAll(reverse);
                }
            }
        }
        
        if(!queue.isEmpty()){
            int min = queue.peek();
            PriorityQueue<Integer> reverse = new PriorityQueue<>((o1, o2)-> o2-o1);
            reverse.addAll(queue);
            int max = reverse.poll();
            answer = new int[] {max, min};
        }
        
        return answer;
    }
}