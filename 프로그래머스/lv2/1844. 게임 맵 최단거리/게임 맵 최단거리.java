import java.util.*;

class Solution {
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        maps[N-1][M-1] = -1; // 도착지 표시
        
        if(ROR(maps) == -1){
            min = -1;
        }
        
        return min;
    }
    
    static int ROR(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];
        q.add(new int[] {0, 0});
        int count = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            
            for(int i = 0; i < size; i++){
                int[] current = q.poll();

                for(int d = 0; d < 4; d++){
                    int nx = current[0] + dx[d];
                    int ny = current[1] + dy[d];
                    
                    if(nx >= N || nx < 0 || ny >= M || ny < 0){
                        continue;
                    }
                    
                    if(maps[nx][ny] == -1){ // 도착지 도착하면 min값 갱신
                        min = Math.min(min, count+1);
                        return min;
                    }

                    if(maps[nx][ny] == 0){ // 벽일 경우 패스
                        continue;
                    }

                    if(visited[nx][ny]){ // 방문한 칸일 경우 패스
                        continue;
                    }

                    // 벽이 아니고, 방문하지 않았으면 
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        return -1;
    }
}