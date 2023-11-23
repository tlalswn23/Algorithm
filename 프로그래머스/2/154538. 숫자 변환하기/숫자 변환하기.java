import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        int cnt = 0;
        int current = y;
        
        while(current > 0){
            int size  = queue.size();
            
            for(int i = 0; i < size; i++){
                current = queue.poll();
                
                if(current == x){   
                    return cnt;
                }

                if(current%3 == 0){
                    queue.add(current/3);
                }

                if(current%2 == 0){
                    queue.add(current/2);
                }

                queue.add(current-n); 
            }
            cnt++;  
        }
        
        return -1;
    }
}