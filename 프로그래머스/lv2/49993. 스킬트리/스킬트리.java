import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < skill.length(); i++){
            map.put(skill.charAt(i), i+1);
        }
        
        for(String str : skill_trees){
            int current = 0;
            boolean check = true;
            
            for(int i = 0; i < str.length(); i++){
                if(!map.containsKey(str.charAt(i))){
                    continue;
                }
                
                if((map.get(str.charAt(i))-current) > 1){
                    check = false;
                    break;
                }
                
                
                current = map.get(str.charAt(i));
            }
            
            if(check){
                System.out.println(str);
                answer++;
            }
        }
        
        return answer;
    }
}