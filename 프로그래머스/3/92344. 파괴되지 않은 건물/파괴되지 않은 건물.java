
import java.util.*;

class Solution {
    static int[][] map;
    static int N, M;
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        map = new int[board.length+1][board[0].length+1];
        N = board.length;
        M = board[0].length;
        
        for(int i = 0; i < skill.length; i++){
            int[] arr = skill[i];
            int x1 = arr[1], y1 = arr[2];
            int x2 = arr[3], y2 = arr[4];
            int degree = arr[5];
            if(arr[0] == 1){
                degree *= -1;
            }
            
            map[x1][y1] += degree;
            map[x1][y2+1] += (degree * -1);
            map[x2+1][y1] += (degree * -1);
            map[x2+1][y2+1] += degree;
            
        }
        calcBuilding(map);
        
        return countBuilding(board, map);
    }
    
    static int countBuilding(int[][] board, int[][] map){
        int count = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                if(board[i][j] + map[i][j] > 0){
                    count++;
                }
            }
            System.out.println();
        }
        
        return count;
    }
    
    static void calcBuilding(int[][] map){
        // 가로
        for(int i = 0; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                map[i][j] += map[i][j-1];
            }
        }
        
        // 세로
        for(int i = 0; i < M+1; i++){
            for(int j = 1; j < N+1; j++){
                map[j][i] += map[j-1][i];
            }
        }
    }
}