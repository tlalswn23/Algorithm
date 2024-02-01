import java.util.*;

class Solution {
    static Stack<Character> stack;
    
    boolean solution(String s) {
        boolean answer = true;
        stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                
                stack.pop();
                continue;
            }
            
            // '('이면 스택에 넣기
            stack.push('(');
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}