import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int exit = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            int enter = routes[i][0];
            if(enter <= exit){
                continue;
            }
            
            answer++;
            exit = routes[i][1];
        }
        
        return answer;
    }
}

// 시작점 순으로 정렬
// 시작점이 끝점보다 작거나 같으면 계속, 시작점이 끝점보다 크면 cnt+1하고 끝점 변경