import java.util.*;

class Solution {
    static int answer;
    public int solution(String s) {
        
        checkRight(s);
        
        return answer;
    }
    
    static boolean checkRight(String s){
        
        for(int a = 0; a < s.length(); a++){
            boolean check = true;
            Stack<Character> stack = new Stack<>();
            
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                
                if(c == '{' || c == '[' || c == '('){ // 여는 괄호면 stack에 넣기
                    stack.push(c);
                }

                if(c == '}' || c == ']' || c == ')'){ // 닫는 괄호면 stack에서 꺼내서 일치하는 지 확인
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    
                    char c2 = stack.peek();

                    if(!checkCouple(c, c2)){ // 만약 짝이 안맞으면 다음으로
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if(stack.isEmpty() && check){
                answer++; 
            }
            
            String temp = s.substring(1, s.length());
            temp += s.charAt(0);
            s = temp;
        }
        
        return true;
    }
    
    static boolean checkCouple(char c2, char c1){
        if(c1 == '(' && c2 == ')'){
            return true;
        }
        
        if(c1 == '[' && c2 == ']'){
            return true;
        }
        
        if(c1 == '{' && c2 == '}'){
            return true;
        }
        
        return false;
    }
}