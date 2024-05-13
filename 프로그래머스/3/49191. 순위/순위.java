import java.util.*;

class Solution {
    static boolean[] visited;
    static int N, P, C;
    static List<Integer>[] parent, child;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        parent = new ArrayList[n+1];
        child = new ArrayList[n+1];
        N = n;
        
        for(int i = 0; i <= n; i++){
            parent[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            
            parent[lose].add(win);
            child[win].add(lose);
        }
        
        // 모든 노드에 대해 부모+자식 노드 개수 확인
        for(int i = 1; i <= n; i++){
            P = 0; C = 0;
            
            visited = new boolean[n+1];
            countParent(i);
            
            visited = new boolean[n+1];
            countChild(i);
            
            if((P+C) == n-1){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void countParent(int v){
        
        for(int i = 0; i < parent[v].size(); i++){
            if(visited[parent[v].get(i)]){
                continue;
            }
            
            visited[parent[v].get(i)] = true;
            P++;
            countParent(parent[v].get(i));
        }
    }
    
    static void countChild(int v){
        
        for(int i = 0; i < child[v].size(); i++){
            if(visited[child[v].get(i)]){
                continue;
            }
            
            visited[child[v].get(i)] = true;
            C++;
            countChild(child[v].get(i));
        }
    }
}