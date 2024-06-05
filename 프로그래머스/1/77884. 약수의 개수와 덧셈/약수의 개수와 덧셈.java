import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){
            int c = countDivisor(i);
            
            if(c % 2 == 0){ // 짝수일 경우 더하기 
                answer += i;
                continue;
            }
            
            if(c % 2 != 0){ // 홀수일 경우 빼기
                answer -= i;
            }
        }
        
        return answer;
    }
    
    static int countDivisor(int num){
        int cnt = 0;
        
        for(int i = 1; i <= num; i++){
            
            if(num % i == 0){
                cnt++;
            }
        }
        
        return cnt;
    }
}