import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int N = wallpaper.length; 
        int M = wallpaper[0].length();
        char[][] map = new char[N][M];
        answer[0] = N;
        answer[1] = M;
        answer[2] = 0;
        answer[3] = 0;
        
        for(int i = 0; i < N; i++){
            map[i] = wallpaper[i].toCharArray();
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '.'){
                    continue;
                }
                
                // 시작점 -> x가 더 작은 것, y도 더 작은 것 
                answer[0] = Math.min(answer[0], i);
                answer[1] = Math.min(answer[1], j);
                
                // 끝점 -> x가 더 큰 것, y도 더 큰 것
                answer[2] = Math.max(answer[2], i+1);
                answer[3] = Math.max(answer[3], j+1);
                
            }
        }
        
        return answer;
    }
}