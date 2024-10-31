import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int quotation = 0; // 인용수
        int count = 0; // 논문 수
        
        for(int i = citations.length-1; i >= 0; i--){
            quotation = citations[i];
            count++;
            
            if(quotation >= count){
                answer = count;
            }
        }
        
        
        return answer;
    }
}