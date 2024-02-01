import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] check = new boolean[n+1];
        Set<Integer> set = new HashSet<>();
        
        // 초기화
        for(int i = 1; i < n+1; i++){
            check[i] = true;
        }
        
        // lost 표시 
        for(int i = 0; i < lost.length; i++){
            check[lost[i]] = false;
            set.add(lost[i]);
        }
        
        for(int i = 0; i < reserve.length; i++){
            check[reserve[i]] = true;
        }
        
        Arrays.sort(reserve);
        
        int count = 0;
        for(int i = 0; i < reserve.length; i++){
            if(set.contains(reserve[i])){
                count++;
                continue;
            }
            
            if(reserve[i] - 1 > 0 && check[reserve[i]-1] == false){
                count++;
                check[reserve[i]-1] = true;
                continue;
            }
            
            if(reserve[i] + 1 <= n && check[reserve[i]+1] == false){
                count++;
                check[reserve[i]+1] = true;
            }
        }
        
        return answer + count;
    }
}