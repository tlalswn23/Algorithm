import java.util.*;

class Solution {
    static Map<String, Integer> map;
    
    public int solution(String s) {
        String answer = "";
        map = new HashMap<>();
        
        setMap();
        
        int index = 0;
        String temp = "";
        
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){ // 숫자이면 
                answer += s.charAt(index); // 숫자는 바로 포함 
            }else{ // 문자이면 
                temp += s.charAt(index); // 먼저 문자 추가 
                if(map.containsKey(temp)){ // 맵에 포함되면 
                    answer += map.get(temp).toString(); // 숫자로 변경해서 추가 
                    temp = ""; // 초기화 
                }
            }
            
            index++;
        }
  
        return Integer.parseInt(answer);
    }
    
    static void setMap(){
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}