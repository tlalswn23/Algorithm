import java.util.*;

class Solution
{
    static Stack<Character> stack;
    
    public int solution(String s)
    {
        int answer = 0;
        stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            
            char c = stack.peek();
            if(c == s.charAt(i)){
                stack.pop();
                continue;
            }
            
            stack.push(s.charAt(i));
        }

        if(stack.isEmpty()){
            answer = 1;
        }
        
        return answer;
    }
}