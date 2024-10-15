import java.util.*;

class Solution {
    static List<Integer>[] network;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        network = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            network[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(computers[i][j] == 1){
                    network[i].add(j);
                    network[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            findNet(i);
            answer++;
        }
        
        return answer;
    }
    
    static void findNet(int num){
        
        // 방문안했으면
        for(int i = 0; i < network[num].size(); i++){
            int n = network[num].get(i);
            
            if(visited[n]){
                continue;
            }
            
            visited[n] = true;
            findNet(n);
        }
    }
}