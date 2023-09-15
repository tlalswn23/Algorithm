import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
    
        // 공백이 여러 개일 수 있다
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){ // 공백 만나면 앞에 스트링 변경
                if(temp != "" && !temp.isEmpty()){
                    temp = temp.toLowerCase();
                    temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
                    answer += temp;
                    temp = ""; // 초기화
                }
                answer += " ";
                continue;
            }
            temp += s.charAt(i)+"";
        }
        
        if(temp != "" && !temp.isEmpty()){
            temp = temp.toLowerCase();
            temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
        }
        
        return answer+temp;
    }
}