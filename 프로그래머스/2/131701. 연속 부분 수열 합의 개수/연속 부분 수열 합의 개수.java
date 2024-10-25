import java.util.*;

class Solution {
    static Set<Integer> sum;
    
    public int solution(int[] elements) {
        sum = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++){ // 시작점
            for(int j = 1; j <= elements.length; j++){ // 길이 
                int total = 0;
                
                for(int n = 0; n < j; n++){ // 연속 합 저장 
                    total += elements[(i+n)%elements.length];
                }
                
                sum.add(total);
            }
        }
        
        return sum.size();
    }

}