import java.util.*;

class Solution {
    static int A, B, answer;
    public int solution(int a, int b, int n) {
        A = a;
        B = b;
        
        // a개를 주면 b개를 주는 마트
        // n개의 빈병을 가지고 있다
        
        getCoke(n);
        
        return answer;
    }
    
    static void getCoke(int cnt){
        if(cnt < A){
            return;
        }
        
        int newCoke = (cnt / A) * B;
        answer += newCoke;
        getCoke((cnt % A) + newCoke);
    }
}