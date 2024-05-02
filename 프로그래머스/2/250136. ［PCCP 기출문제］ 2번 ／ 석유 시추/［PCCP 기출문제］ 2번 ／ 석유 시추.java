import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited, mapVisited;
    static int total, R, C, max, count; // 석유 덩어리 개수
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, Integer> countMap;
    
    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        map = new int[R][C];
        copyMap(land, map);
        countMap = new HashMap<>();
        visited = new boolean[R][C];
        count = 1;
        
        // BFS
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(land[i][j] == 0){
                    continue;
                }
                
                if(visited[i][j]){
                    continue;
                }
                
                // 석유 있는 장소이면 BFS로 개수 찾기
                total = 0;
                BFS(i, j);
                countMap.put(count, total);
                count++;
            }
        }
        
        // 석유 수 카운트
        for(int i = 0; i < C; i++){
            total = 0;
            countOil(i);
            max = Math.max(max, total);
        }
        
        return max;
    }
    
    static void countOil(int n){
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        for(int i = 0; i < R; i++){
            if(map[i][n] == 0){
                continue;
            }
            
            if(set.contains(map[i][n])){
                continue;
            }
            
            set.add(map[i][n]);
            total += countMap.get(map[i][n]);
        }
    }
    
    // BFS로 찾으면서 count 숫자로 표시 
    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        map[x][y] = count;
        total++;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                
                if(!checkRange(nx, ny)){
                    continue;
                }
                
                if(visited[nx][ny]){
                    continue;
                }
                
                if(map[nx][ny] != 1 && map[nx][ny] < count){
                    continue;
                }
                
                map[nx][ny] = count;
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
                total++;
            }
        }
    }
    
    static boolean checkRange(int nx, int ny){
        if(nx < 0 || nx >= R || ny < 0 || ny >= C){
            return false;
        }
        return true;
    }
    
    static void copyMap(int[][] map, int[][] temp){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                temp[i][j] = map[i][j];
            }
        }
    }
    
    static void printMap(int[][] temp){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
    }
}