import java.util.*;

class Solution {
    static int[] start, end;
    static int N, M, K, D;
    static int[][] direction = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static char[] charD = {'d', 'l', 'r', 'u'}; // 사전순으로 탐색 
    static String answer;
    static boolean check;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "impossible";
        N = n; M = m; K = k;
        start = new int[] {x, y};
        end = new int[] {r, c};
       
        D = Math.abs(x - r) + Math.abs(y - c); // 장애물이 없으므로 맨해튼 거리 
        
        if(D > K){
            return answer;
        }
        
        if((K - D) % 2 == 1){
            return answer;
        }
        
        findExit(0, "", start);
        
        return answer;
    }
    
    // 도달 가능할 때만 호출해서 최적화 
    static void findExit(int n, String str, int[] current){
        
        if(check || n > K - 1){
            return;
        }
        
        for(int d = 0; d < 4; d++){
            if(check){
                return;
            }
            
            int nx = current[0] + direction[d][0];
            int ny = current[1] + direction[d][1];
            
            if(nx < 1 || nx >= N+1 || ny < 1 || ny >= M+1){
                continue;
            }
            
            int dis = Math.abs(nx - end[0]) + Math.abs(ny - end[1]);
            if(dis > (K - n - 1)){
                continue;
            }
            
            if((K - n - 1 - dis) % 2 == 1){
                continue;
            }
            
            if(n < K - 1){
                findExit(n+1, str+charD[d], new int[] {nx, ny});
            }
            
            if(n == K - 1 && (end[0] == nx) && (end[1] == ny)){
                answer = str + charD[d];
                check = true;
                return;
            }
        }
    }
}