import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = A.length-1;
        int b = B.length-1;
        
        while(true){
            if(a < 0 || b < 0){
                break;
            }
            
            if(A[a] < B[b]){
                answer++;
                a--;
                b--;
            }else{
                a--;
            }
        }
        
        return answer;
    }
}