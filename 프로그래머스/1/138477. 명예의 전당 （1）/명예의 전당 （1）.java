import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> scores = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++){
            scores.add(score[i]);
            Collections.sort(scores);
            
            if(i >= k){
                scores.remove(0);
            }
        
            answer[i] = scores.get(0);
        }
        
        
        return answer;
    }
}