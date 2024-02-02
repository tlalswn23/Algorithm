import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] reverse = new int[citations.length];
        
        Arrays.sort(citations); // 정렬 
        for(int i = 0; i < citations.length; i++){
            reverse[i] = citations[citations.length-1-i];
        }
        
        for(int i = 0; i < citations.length; i++){
            if((i+1) <= reverse[i]){
                answer = i+1;
            }
        }
        
        return answer;
    }
}