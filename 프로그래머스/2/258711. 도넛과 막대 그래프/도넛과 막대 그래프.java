import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static int newV;
    static boolean[] visited;
    static int v, e, maxV;
    static int[] answer;
    
    public int[] solution(int[][] edges) {
        answer = new int[4];
        
        for(int i = 0; i < edges.length; i++){
            maxV = Math.max(maxV, Math.max(edges[i][0], edges[i][1]));
        }
        
        int[] indegree = new int[maxV+1];
        graph = new ArrayList[maxV+1];
        
        for(int i = 1; i < maxV+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 단방향 그래프 만들기
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            indegree[edges[i][1]]++;
        }


        int max = 0; int num = 0;
        for(int i = 1; i < maxV+1; i++){
            if(indegree[i] != 0){ // 들어오는 간선이 없어야 새로 생성한 정점임 
                continue;
            }
            
            if(max < graph[i].size()){
                max = graph[i].size();
                num = i;
            }
        }
        
        answer[0] = num; // 새로 생성한 정점
        
        // 새로 생성한 정점에 연결된 모든 그래프 탐색
        for(int i = 0; i < graph[num].size(); i++){
            findType(graph[num].get(i));
        }

        return answer;
    }
    
    // 어떤 타입의 그래프인지 탐색하는 함수
    static void findType(int start){
        // 주어진 그래프의 특징에 따라 결정(정점의 수와 간선의 수)
        
        boolean[] visited = new boolean[maxV+1];
        int cntV = 1, cntE = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            int size = graph[current].size();
            cntE += size;
            
            for(int i = 0; i < size; i++){
                if(visited[graph[current].get(i)]){
                    continue;
                }
                
                visited[graph[current].get(i)] = true;
                queue.add(graph[current].get(i));
                cntV++;
            }
        }
        
        // System.out.println(cntV+" "+cntE);
        
        if(cntV == cntE){
            answer[1]++;
        }else if(cntV-1 == cntE){
            answer[2]++;
        }else{
            answer[3]++;
        }
        
    }
}

// 생성한 점 : 들어오는 간선 0개, 나가는 간선 2개 이상인 정점

// 1. 다음 갈 곳이 없으면 막대
// 2. 다음 갈 곳이 있고, 해당 정점이 시작점이면 8자 or 도넛
// 2-1. 해당 정점이 시작점이고 다음 정점이 아직 방문 안한 곳이면 8자
// 2-2. 해당 정점이 시작점이고 다음 정점이 방문한 곳이면 도넛