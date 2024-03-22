import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i = 0; i <= d; i+=k){

            answer += findMaxY(d, i, k);
        }
        
        return answer;
    }
    
    static int findMaxY(int d, int x, int k){
        long n1 = (long)d*d;
        long n2 = (long)x*x;
        int maxY = (int)Math.sqrt(n1 - n2);
        
        return (maxY/k) + 1;
    }
}