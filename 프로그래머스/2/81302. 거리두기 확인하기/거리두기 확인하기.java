import java.util.*;

class Solution {
    static char[][] room;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> applicants;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++){
            room = new char[5][5];
            applicants = new ArrayList<>();
            
            for(int j = 0; j < 5; j++){
                room[j] = places[i][j].toCharArray();
                for(int k = 0; k < 5; k++){
                    if(room[j][k] == 'P'){
                        applicants.add(new int[] {j, k});
                    }
                }
            }
            
            answer[i] = checkSit();
        }
        
        return answer;
    }
    
    // BFS로 각 지원자에서 2칸 이하에 누군가 있으면 return 0
    static int checkSit(){
        
        for(int i = 0; i < applicants.size(); i++){ // 모든 지원자 돌면서 
            boolean[][] visited = new boolean[5][5];
            Queue<int[]> q = new LinkedList<>();
            int cnt = 0;
            
            q.add(applicants.get(i));
            
            while(cnt < 2){
                int size = q.size();
                
                for(int j = 0; j < size; j++){
                    int[] current = q.poll();
                    visited[current[0]][current[1]] = true;
                    
                    for(int d = 0; d < 4; d++){
                        int nx = current[0] + dx[d];
                        int ny = current[1] + dy[d];
                        
                        if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5){
                            continue;
                        }
                        
                        
                        if(room[nx][ny] == 'X'){
                            continue;
                        }
                        
                        if(visited[nx][ny]){
                            continue;
                        }
                        
                        if(room[nx][ny] == 'P'){ // 다른 사람이 있으면 return 0
                            return 0;
                        }
                        
                        q.add(new int[] {nx, ny});
                    }
                }
                cnt++;
            }
        }
        return 1;
    }
}