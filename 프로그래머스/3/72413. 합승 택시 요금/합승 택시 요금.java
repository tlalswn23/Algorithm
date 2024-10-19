import java.util.*;

class Solution {
    static List<int[]>[] graph;
    static int N;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        N =n;
        graph = new ArrayList[n+1];
        int[] StoV = new int[n+1]; // 시작점에서 임의의 점 V까지 최단거리
        int[] AtoV = new int[n+1]; // 도착지에서 임의의 점 V까지 최단거리
        int[] BtoV = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 가중치 그래프 만들기
        for(int i = 0; i < fares.length; i++){
            graph[fares[i][0]].add(new int[] {fares[i][1], fares[i][2]});
            graph[fares[i][1]].add(new int[] {fares[i][0], fares[i][2]});
        }
        
        // StoV, AtoV, BtoV 다익스트라로 최단거리 구하기
        StoV = findRoute(s); 
        AtoV = findRoute(a); 
        BtoV = findRoute(b); 

        // 셋의 합의 최소가 되는 정답 찾기
        for(int i = 1; i <= n; i++){
            if(i == s){
                continue;
            }
            
            answer = Math.min(answer, StoV[i]+AtoV[i]+BtoV[i]);
        }
        
        return Math.min(answer, AtoV[s]+BtoV[s]);
    }
    
    // 다익스트라 : 시작점에서 모든 정점까지 최단거리 구하기
    static int[] findRoute(int start){
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] route = new int[N+1];
        
        queue.add(new int[] {start, 0}); // 시작점, 거리 0
        Arrays.fill(route, Integer.MAX_VALUE); // 다익스트라 초기화
        route[start] = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int i = 0; i < graph[current[0]].size(); i++){
                int[] next = graph[current[0]].get(i);
                
                if(route[next[0]] > route[current[0]] + next[1]){
                    route[next[0]] = route[current[0]] + next[1];
                    queue.add(new int[] {next[0], next[1]});
                }
            }
        }
        
        return route;
    }
    
    static void printMap(int[] arr){
        for(int i = 1; i <= N; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
