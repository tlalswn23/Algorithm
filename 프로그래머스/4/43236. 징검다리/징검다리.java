import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            // mid가 최소가 되기 위해 n보다 많은 바위를 제거해야 하면 거리를 줄여야 함
            int cnt = countRocks(mid, rocks, distance);
            if(n < cnt){
                right = mid - 1;
            }else{
                // 최소값 중 최대값을 찾아야 되기 때문에 mid를 포함해서 더 찾아봄 
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
    
    // mid가 최소값이 되기 위해 제거해야 하는 돌의 수 
    static int countRocks(int d, int[] rocks, int distance){
        int cnt = 0;
        int idx = 0;
        
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - idx < d){
                cnt++;
                continue;
            }
            
            idx = rocks[i];
        }
        
        if(distance - idx < d){
            cnt++;
        }
        
        return cnt;
    }
}