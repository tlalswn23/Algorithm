import java.util.*;

class Solution {
    static Queue<int[]>[] route; // 각 로봇의 이동경로 저장 
    static int[][] map;
    static int answer;
    
    public int solution(int[][] points, int[][] routes) {
        route = new LinkedList[routes.length];
        map = new int[101][101];
        
        // 1. 각 로봇의 이동경로 찾기
        findRoute(points, routes);
        
        // 2. 이동하며 count 하기 
        moveRobote();
        
        return answer;
    }
    
    static void moveRobote(){
        int arrive = 0;
        
        while(arrive < route.length){ // 모든 로봇이 도착할 때까지 반복 
            int robote = 0;
            
            // System.out.println("-----");
            for(int i = 0; i < route.length; i++){
                if(route[i].isEmpty()){ // 이동 경로가 비어있으면 다음 로봇으로 넘어가기 
                    robote++;
                    continue;
                }
                
                // 경로가 남았으면 맵에 표시 
                int[] current = route[i].poll();
                map[current[0]][current[1]]++;
            }
            
            int hit = 0;
            // 맵 돌면서 충돌한 로봇있는지 확인 
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if(map[i][j] > 1){
                        hit++;
                    }
                    
                    if(map[i][j] > 0){ // 맵 초기화
                        map[i][j] = 0;
                    }
                }
            }
            
            answer += hit;
            arrive = Math.max(arrive, robote);
        }
    }
    
    static void findRoute(int[][] points, int[][] routes){
        
        // 각 로봇만큼 돌면서 
        for(int i = 0; i < routes.length; i++){
            route[i] = new LinkedList<>();
            int current = routes[i][0];
            route[i].add(new int[] {points[current-1][0], points[current-1][1]});
            
            for(int j = 1; j < routes[i].length; j++){
                int next = routes[i][j];
                int x = points[next-1][0] - points[current-1][0];
                int y = points[next-1][1] - points[current-1][1];
                int cx = points[current-1][0];
                int cy = points[current-1][1];
                
                // System.out.println(x);
                
                // 우선순위에 따라 x축 먼저 쭉- 이동 후에 y축으로 쭉-이동
                // 1. x축 이동 
                if(x != 0){ // 이동 해야하면 
                    if(x > 0){ // 다음 이동 좌표가 더 크면 
                        int cnt = 1;
                        while(x > 0){
                            route[i].add(new int[] {cx+1, cy});
                            cx++;
                            x--;
                        }
                    }else{ // 다음 이동 좌표가 더 작으면 
                        int cnt = -1;
                        while(x < 0){
                            route[i].add(new int[] {cx-1, points[current-1][1]});
                            x++;
                            cx--;
                        }
                    }
                }
                
                // 2. y축 이동
                if(y != 0){
                    if(y > 0){
                        int cnt = 1;
                        while(y > 0){
                            route[i].add(new int[] {cx, cy+1});
                            y--;
                            cy++;
                        }
                    }else{
                        int cnt = -1;
                        while(y < 0){
                            route[i].add(new int[] {cx, cy-1});
                            y++;
                            cy--;
                        }
                    }
                }
                
                current = next;
            }
        }
    }
}