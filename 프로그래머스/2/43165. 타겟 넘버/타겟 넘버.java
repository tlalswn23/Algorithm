import java.util.*;

class Solution {
    static int N, T, cnt;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        
        dfs(0, 0, numbers);
        
        return cnt;
    }
    
    static void dfs(int idx, int sum, int[] numbers){
        if(idx == N){
            
            if(sum == T){
                cnt++;
            }
            
            return;
        }
        
        // 1. 더하기
        dfs(idx+1, sum+numbers[idx], numbers);
        
        // 2. 빼기
        dfs(idx+1, sum-numbers[idx], numbers);
    }
}