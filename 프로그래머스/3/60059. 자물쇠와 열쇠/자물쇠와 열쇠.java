import java.util.*;

class Solution {
    static int N, M;
    static int[][] ground;
    
    public boolean solution(int[][] key, int[][] lock) {
        N = key.length;
        M = lock.length;
        ground = new int[M+(N*2)-2][M+(N*2)-2];
        
        // 전체맵 초기화
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                ground[N-1+i][N-1+j] = lock[i][j];
            }
        }
        
        for(int i = 0; i < 4; i++){
            rotation(key);
            for(int a = 0; a < M+N-1; a++){
                for(int b = 0; b < M+N-1; b++){
                    if(checkLock(a, b, key)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    static boolean checkLock(int sx, int sy, int[][] key){
        int[][] temp = copyMap(ground);
        
        // 열쇠 더하기 
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                temp[i+sx][j+sy] += key[i][j];
            }
        }
        
        // 자물쇠 확인 
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                if(temp[N-1+i][N-1+j] != 1){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static void rotation(int[][] key){
        int[][] temp = copyMap(key);
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                key[j][N-1-i] = temp[i][j];
            }
        }
    }
    
    static int[][] copyMap(int[][] key){
        int[][] temp = new int[key.length][key.length];
        
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                temp[i][j] = key[i][j];
            }
        }
        
        return temp;
    }
    
    static void printMap(int[][] key){
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                System.out.print(key[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
}