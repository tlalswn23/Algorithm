import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                stack.push(i);
                answer += String.valueOf(i);
            }
        }
        
        answer += "0";
        
        int size = stack.size();
        for(int i = 0; i < size; i++){
            answer += String.valueOf(stack.pop());
        }
        
        return answer;
    }
}