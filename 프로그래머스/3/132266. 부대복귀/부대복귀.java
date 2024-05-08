import java.util.*;

class Solution {
    static int[] dijkstra;
    static boolean[] visited;
    static List<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dijkstra = new int[n+1];
        visited = new boolean[n+1];
        graph = new LinkedList[n+1];
        
        // 무한대로 초기화 
        for(int i = 0; i <= n; i++){
            dijkstra[i] = Integer.MAX_VALUE;
            graph[i] = new LinkedList<>();
        }
        
        // 그래프 초기화
        for(int i = 0; i < roads.length; i++){
            int n1 = roads[i][0];
            int n2 = roads[i][1];
            
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        
        
        Dijkstra(destination);
        
        for(int i = 0; i < sources.length; i++){
            int cost = -1;
            
            if(dijkstra[sources[i]] != Integer.MAX_VALUE){
                cost = dijkstra[sources[i]];
            }
            
            answer[i] = cost;
        }
        
        return answer;
    }
    
    static void Dijkstra(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 출발지 방문표기
        dijkstra[start] = 0;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            
            for(int i = 0; i < graph[v].size(); i++){
                int node = graph[v].get(i);
                
                if(visited[node]){
                    continue;
                }
                
                if(dijkstra[node] <= dijkstra[v]+1){
                    continue;
                }
                
                dijkstra[node] = dijkstra[v]+1;
                visited[node] = true;
                queue.add(node);
            }
        }
    }
}