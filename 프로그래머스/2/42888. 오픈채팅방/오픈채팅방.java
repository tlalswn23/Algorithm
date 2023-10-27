import java.util.*;

class Solution {
    static Map<String, String> users;
    
    public String[] solution(String[] record) {
        int count = 0;
        users = new HashMap<>();
        
        for(String s : record){
            String[] temp = s.split(" ");
            if(temp[0].equals("Enter") || temp[0].equals("Change")){
                users.put(temp[1], temp[2]);
            }
            
            if(temp[0].equals("Enter") || temp[0].equals("Leave")){
                count++;
            }
        }
        
        
        String[] answer = new String[count];
        count = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            
            if(temp[0].equals("Enter")){
                answer[count] = users.get(temp[1]) +"님이 들어왔습니다.";
                count++;
                continue;
            }
            
            if(temp[0].equals("Leave")){
                answer[count] = users.get(temp[1])+"님이 나갔습니다.";
                count++;
            }
        }
        
        return answer;
    }
}

// enter 일 때만 map에 닉네임 저장 
// input 돌면서 enter/leave에 따라 다르게 출력