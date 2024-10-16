import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        Set<Integer> root = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            parent[i] = find(i);
        }
        
        for(int i = 0; i < n; i++){
            root.add(parent[i]);
        }
        
        return root.size();
    }
    
    // 같은 그래프로 합치는 함수 
    static boolean union(int x, int y){
        int xp = find(x);
        int yp = find(y);
        
        // 이미 같은 그래프
        if(xp == yp){
            return false;
        }
        
        if(xp < yp){
            parent[yp] = xp;
        }else{
            parent[xp] = yp; 
        }
        return true;

    }
    
    // 부모노드 찾는 함수 
    static int find(int n){
        if(parent[n] == n){
            return n;
        }
        
        return find(parent[n]);

    }
}

// union find 후 root 노드의 개수 세아리기