import java.util.*;

class Solution {
    static int[][] map; // 사각형은 1
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] checkx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] checky = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        map = new int[102][102]; 
        
        // 사각형 표시
        for(int i = 0; i < rectangle.length; i++){
            paint(rectangle[i]);
        }

        // 테두리 따라가면서 item 찾기
        answer = border(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer/2;
    }
    
    static int border(int cx, int cy, int ix, int iy){
        int cnt = 0;
        visited = new boolean[102][102];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {cx, cy});
        visited[cx][cy] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                
                for(int d = 0; d < 4; d++){
                    int nx = current[0] + dx[d];
                    int ny = current[1] + dy[d];

                    if(visited[nx][ny]){ // 방문한 곳 x
                        continue;
                    }
                    
                    if(map[nx][ny] == 0){ // 사각형이 아닌 곳 x
                        continue;
                    }

                    if(checkBorder(nx, ny)){ // 테두리이면 
                        if(nx == ix && ny == iy){
                            return cnt+1;
                        }
                        visited[nx][ny] = true;
                        map[nx][ny] = 2;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
            cnt++;
        }
        
        return -1;
    }
    
    // 테두리인지 확인하는 함수 *****
    static boolean checkBorder(int nx, int ny){
        int count = 0;
        for(int d = 0; d < 8; d++){
            if(map[nx+checkx[d]][ny+checky[d]] == 0){
                return true;
            }
        }

        return false;
    }
    
    static void paint(int[] info){
        for(int i = info[0]*2; i <= info[2]*2; i++){
            for(int j = info[1]*2; j <= info[3]*2; j++){
                map[i][j] = 1;
            }
        }
    }
    
    static void printMap(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}