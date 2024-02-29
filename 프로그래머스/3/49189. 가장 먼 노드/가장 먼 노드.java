import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] cost = new int[n+1];
        List<Integer>[] graph = new ArrayList[n+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        // 큰 값으로 초기화 
        for(int i = 0; i <= n; i++){
            cost[i] = Integer.MAX_VALUE-1;
        }
        cost[1] = 0;
        
        // 그래프 초기화
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 연결 (양방향)
        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int i = q.poll();
            
            for(int j = 0; j < graph[i].size(); j++){
                int next = graph[i].get(j);
                if(cost[i]+1 < cost[next]){
                    cost[next] = cost[i]+1;
                    q.add(next);
                }
            }
        }
        
        // max 값 구하기 
        int max = 0;
        for(int i = 2; i <= n; i++){
            max = Math.max(max, cost[i]);
            queue.add(cost[i]);
        }
        
        // max값과 일치하는 cost 수 구하기
        while(!queue.isEmpty()){
            int c = queue.poll();
            if(c < max){
                break;
            }
            
            if(c == max){
                answer++;
            }
        }
        
        return answer;
    }
}