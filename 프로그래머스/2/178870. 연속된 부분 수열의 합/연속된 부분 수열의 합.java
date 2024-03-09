import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        int left = 0;
        int sum = 0;
        int size = sequence.length;
        
        for(int i = 0; i < sequence.length; i++){
            sum += sequence[i];
            if(sum > k){ // 수열의 합이 k를 초과하면 
                while(sum > k){
                    sum -= sequence[left];
                    left++;
                }
            }
            
            if(sum == k){ // 구간의 합이 k인 경우 
                if(i - left < size){ // 길이가 더 짧으면 구간 갱신 
                    answer[0] = left;
                    answer[1] = i;
                    size = answer[1] - answer[0];
                }
            }
        }
        
        return answer;
    }
}