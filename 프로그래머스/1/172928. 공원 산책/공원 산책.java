import java.util.*;

class Solution {
    static char[][] map;
    static int[] answer;
    static int R, C;
    
    public int[] solution(String[] park, String[] routes) {
        answer = new int[2];
        map = new char[park.length][park.length];
        R = park.length;
        C = park[0].length();
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] = park[i].charAt(j);
                
                if(map[i][j] == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            goRoute(answer, routes[i]);
        }
        
        return answer;
    }
    
    static void goRoute(int[] current, String comm){
        String[] str = comm.split(" ");
        int[] d = direction(str[0].charAt(0));
        int nx = current[0];
        int ny = current[1];
        
        for(int i = 0; i < Integer.parseInt(str[1]); i++){
            nx += d[0];
            ny += d[1];
            
            if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X'){
                return;
            }
        }
        
        answer[0] = nx;
        answer[1] = ny;
    }
    
    static int[] direction(char c){
        if(c == 'N'){
            return new int[] {-1, 0};
        }
        
        if(c == 'S'){
            return new int[] {1, 0};
        }
        
        if(c == 'W'){
            return new int[] {0, -1};
        }
        
        return new int[] {0, 1};
    }
}

// 길은 O, 장애물은 X