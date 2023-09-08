import java.util.*;

class Solution {
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
    
    static void dfs(int[] numbers, int target, int sum, int idx){
        
        if(idx == numbers.length){
            if(sum == target){
                cnt++;
            }
            return;
        }
        
        dfs(numbers, target, sum+numbers[idx], idx+1);
        dfs(numbers, target, sum-numbers[idx], idx+1);
        
    }
}