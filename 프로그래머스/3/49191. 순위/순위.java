import java.util.*;

class Solution {
    static int[][] win;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        win = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int[] match = results[i];
            
            win[match[0]][match[1]] = 1; // 이겼으면 1
            win[match[1]][match[0]] = -1; // 졌으면 -1
        }
 
        for(int k = 1; k < n+1; k++){ // 1부터 n까지의 선수 모두 탐색
            for(int i = 1; i < n+1; i++){
                for(int j = 1; j < n+1; j++){
                    
                    // i -> a이고 a -> b이면 i -> b임을 이용
                    if(win[i][k] == 1 && win[k][j] == 1){
                        win[i][j] = 1;
                        win[j][i] = -1;
                    }
                }
            }
        }
        
        for(int i = 1; i < n+1; i++){ // 모든 선수에 대해 모든 선수와의 관계 확인하기 
            int result = 0;
            
            for(int j = 1; j < n+1; j++){
                if(win[i][j] != 0){ // 확인된 관계가 있으면 카운트+1
                    result++;
                }
            }
            
            if(result == n-1){
                answer++;
            }
        }
        
        return answer;
    }
}