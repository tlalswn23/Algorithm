import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        Queue<Integer> queue = new LinkedList<>();
        
        // 초기화 
        for(int i = 1; i < n+1; i++){
            queue.add(i);
        }
        
        // 토너먼트 진행 
        while(n > 1){
            int size = queue.size();
            
            for(int i = 0; i < size; i = i+2){
                int n1 = queue.poll();
                int n2 = queue.poll();
                
                if((n1 == a && n2 == b) || (n1 == b && n2 == a)){ // a와 b가 해당 라운드에서 만나면 종료
                    return answer;
                }
                
                if(n1 == a || n2 == a){
                    queue.add(a);
                }else if(n2 == b || n1 == b){
                    queue.add(b);
                }else{
                    queue.add(n1);
                }
            }
            
            n = n/2;
            answer++;
        }

        return answer;
    }
}