import java.util.*;

class Solution {
    static int min, N;
    static List<Integer>[] wire;
    
    public int solution(int n, int[][] wires) {
        wire = new ArrayList[n+1];
        N = n;
        min = n;
        
        for(int i = 0; i < n+1; i++){
            wire[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            wire[v1].add(v2);
            wire[v2].add(v1);
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            wire[v1].remove(Integer.valueOf(v2));
            wire[v2].remove(Integer.valueOf(v1));
            
            int cnt = bfs();
            min  = Math.min(min, Math.abs(n-cnt-cnt));
            
            wire[v1].add(v2);
            wire[v2].add(v1);
            
        }
        
        return min;
    }
    
    static int bfs(){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int count = 0;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;
            
            for(int i = 0; i < wire[current].size(); i++){
                int next = wire[current].get(i);
                
                if(visited[next]){
                    continue;
                }
                
                visited[next] = true;
                queue.add(next);
            }
        }
        return count;
    }
    
    // 1. 한 전선을 끊기 
    // 2. 한 정점에서 연결된 모든 송전탑 세기 
    // 3. n에서 송전탑 개수 뺀 절대값과 min 갱신 
}