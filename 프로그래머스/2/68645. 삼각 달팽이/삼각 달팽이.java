import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        int r = -1;
        int c = 0;
        int R = n; 
        int C = n;
        int max = 0;
        
        for(int i = 1; i <= n; i++){
            max += i;
        }
        
        while(num <= max){
            for(int d = 0; d < 3; d++){
                int nx = dx[d] + r;
                int ny = dy[d] + c;
                
                while(nx < R && ny < C & -1 < nx && -1 < ny && arr[nx][ny] == 0){
                    arr[nx][ny] = num;
                    nx += dx[d];
                    ny += dy[d];
                    num++;
                }
                
                r = nx - dx[d];
                c = ny - dy[d];
            }
        
        }
        
        int idx = 0;
        int answer[] = new int[max];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                answer[idx] = arr[i][j];
                idx++;
            }
        }
        
        return answer;
    }
}