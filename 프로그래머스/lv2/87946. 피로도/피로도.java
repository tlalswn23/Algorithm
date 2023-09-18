import java.util.*;

class Solution {
    static int max, N;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        goDungeon(dungeons, 0, 0, k);
        
        return max;
    }
    
    // 순서 있는 모든 경우의 수
    static void goDungeon(int[][] dungeons, int n, int cnt, int hp){
        if(N == n){ // 배열 끝까지 다 돌았으면 갈 수 있는 던전 개수 비교 후 갱신
            max = Math.max(max, cnt);
            return;
        }
        
        for(int i = 0; i < N; i++){
            
            if(visited[i]){ // 방문한 던전이면 패스
                continue;
            }

            // 방문 안한 던전이면 방문처리, 갈 수 있는 던전이면 카운트 후 넘어가기
            visited[i] = true;
            if(hp >= dungeons[i][0]){
                goDungeon(dungeons, n+1, cnt+1, hp-dungeons[i][1]);
            }

            if(hp < dungeons[i][0]){
                goDungeon(dungeons, n+1, cnt, hp);
            }
            visited[i] = false;
        }
    }
}