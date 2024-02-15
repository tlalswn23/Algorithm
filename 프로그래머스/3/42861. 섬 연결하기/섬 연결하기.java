import java.util.*;

class Solution {
    static class Info{
        int v, cost;
        public Info(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    
    static List<Info>[] graph;
    public int solution(int n, int[][] costs) {
        graph = new ArrayList[n];
        
        // 그래프 초기화
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프에 추가
        for(int i = 0; i < costs.length; i++){
            // 양방향 그래프
            graph[costs[i][0]].add(new Info(costs[i][1], costs[i][2]));
            graph[costs[i][1]].add(new Info(costs[i][0], costs[i][2]));
        }
        
        return MST(n);
    }
    
    static int MST(int n){
        int cnt = 0;
        int total = 0;
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
        boolean[] visited = new boolean[n];
        
        // 임의의 시작점 0에서 출발. 간선정보 저장(도착지, 비용)
        visited[0] = true;
        for(int i = 0; i < graph[0].size(); i++){
            queue.add(graph[0].get(i)); 
        }
        
        while(cnt < n-1){ // 간선 n-1개 뽑을 때까지
            Info next = queue.poll();
            if(visited[next.v]){ // 이미 방문한 간선이면 넘어가기
                continue;
            }
            
            // 방문하지 않은 간선이면 등록 후 연결된 모든 간선 큐에 추가 
            cnt++;
            total += next.cost;
            visited[next.v] = true;
            for(int i = 0; i < graph[next.v].size(); i++){
                queue.add(graph[next.v].get(i));
            }
        }
        
        return total;
    }
}