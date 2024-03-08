import java.util.*;

class Solution {
    static String[] operator = {"+", "-", "*"};
    static boolean[] visited;
    static String[] ocase;
    static long max;
    static Queue<String> queue;
    
    public long solution(String expression) {
        visited = new boolean[3];
        ocase = new String[3];
        queue = new LinkedList<>();
        
        // 연산자 기준으로 잘라야 함 
        int index = 0;
        String temp = "";
        while(index < expression.length()){
            char c = expression.charAt(index);
            
            if(checkOper(c)){ // 연산자이면 
                queue.add(temp);
                temp = "";
                queue.add(c+"");
            }else{
                temp += c;
            }
            
            index++;
        }
        queue.add(temp);
        
        findAllCase(0);
        
        return max;
    }
    
    static boolean checkOper(char c){
        if(c == '+' || c == '-' || c == '*'){
            return true;
        }
        
        return false;
    }
    
    static long calcFormula(){
        long total = 0L;
        Queue<String> q1 = new LinkedList<>(); // 현재 수식
        Deque<String> q2 = new ArrayDeque<>(); // 수식 결과
        
        q1.addAll(queue);
        
        for(int i = 0; i < 3; i++){
            
            while(!q1.isEmpty()){ // 현재 수식의 끝까지 반복
                String c = q1.poll();
                
                if(c.equals(ocase[i])){ // 현재 우선순위의 연산자와 같으면
                    long n1 = Long.parseLong(q2.pollLast()); // 마지막 숫자를 빼야 함
                    long n2 = Long.parseLong(q1.poll()); 
                    q2.add(String.valueOf(getResult(n1, n2, c)));
                    
                    continue;
                }
            
                q2.add(c);
            }
            
            q1.addAll(q2);
            q2.clear();
        }
        
        return Long.parseLong(q1.poll());
    }
    
    static long getResult(long n1, long n2, String c){
        if(c.equals("+")){
            return n1 + n2;
        }
        
        else if(c.equals("-")){
            return n1 - n2;
        }
        
        else{
            return n1 * n2;
        }
    }
    
    static void findAllCase(int n){
        if(n == 3){
            // 각 경우에 대해서 수식 진행 
            max = Math.max(max, Math.abs(calcFormula()));
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            ocase[n] = operator[i];
            findAllCase(n+1);
            visited[i] = false;
        }
    }
}