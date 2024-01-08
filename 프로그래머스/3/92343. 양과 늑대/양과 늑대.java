import java.util.*;

class Solution {
    static List<Integer>[] tree;
    static int cnt;
    
    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[17];
        boolean[] visited = new boolean[info.length];
        
        for(int i = 0; i < 17; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        
        saveSheep(0, 0, 0, info, visited);
        
        return cnt;
    }
    
    static void saveSheep(int index, int sheep, int wolf, int[] info, boolean[] visited){
        
        if(info[index] == 0){ // 현재 노드가 양일 때 
            sheep++;
        }

        if(info[index] == 1){ // 현재 노드가 늑대일 때 
            wolf++;
        }
        
        if(sheep <= wolf){ // 늑대가 양보다 많거나 같아지면 갈 수 없음 
            return;
        }
        
        boolean[] newVisited = visited.clone();
        newVisited[index] = true;
        
        cnt = Math.max(cnt, sheep);
        
        for(int j = 0; j < newVisited.length; j++){
            
            if(!newVisited[j]){
                continue;
            }
            
            for(int i = 0; i < tree[j].size(); i++){
                int current = tree[j].get(i);

                if(newVisited[current]){
                    continue;
                }

                saveSheep(current, sheep, wolf, info, newVisited);
            }
        }
    }
}