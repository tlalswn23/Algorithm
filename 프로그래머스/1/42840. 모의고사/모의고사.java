import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;
        
        // 1번 수포자 
        int idx = 0;
        while(idx < answers.length){
            for(int i = 0; i < ans1.length; i++){
                if(answers[idx] == ans1[i]){
                    answer[0]++;
                }
                idx++;
                
                if(idx >= answers.length){
                    break;
                }
            }
        }
        max = Math.max(max, answer[0]);
                
        // 2번 수포자
        idx = 0;
        while(idx < answers.length){
            for(int i = 0; i < ans2.length; i++){
                if(answers[idx] == ans2[i]){
                    answer[1]++;
                }
                idx++;
                
                if(idx >= answers.length){
                    break;
                }
            }
        }
        max = Math.max(max, answer[1]);
        
         // 3번 수포자 
        idx = 0;
        while(idx < answers.length){
            for(int i = 0; i < ans3.length; i++){
                if(answers[idx] == ans3[i]){
                    answer[2]++;
                }
                idx++;
                
                if(idx >= answers.length){
                    break;
                }
            }
        }
        max = Math.max(max, answer[2]);
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(answer[i] == max){
                list.add(i+1);
            }
        }
        
        int[] temp = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            temp[i] = list.get(i);
        }
        return temp;
    }
}