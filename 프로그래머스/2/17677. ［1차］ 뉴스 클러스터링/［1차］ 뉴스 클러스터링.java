import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int inter, total;
    public int solution(String str1, String str2) {
        map = new HashMap<>();
        
        // str1
        for(int i = 0; i < str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            
            if(checkChar(c1) && checkChar(c2)){ // 둘 다 영문자이면 
                String set = Character.toString(c1)+Character.toString(c2);
                int cnt = 1;
                String key = getEqualsKey(set);
                
                if(!map.isEmpty()){
                    if(!key.equals("-")){ // 포함된 게 있으면
                        cnt += map.get(key);
                    }
                    else{
                        key = set;
                    }
                }else{
                    key = set;
                }
                
                map.put(key, cnt);
            }
        }
        
        // str2
        for(int i = 0; i < str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            
            if(checkChar(c1) && checkChar(c2)){ // 둘 다 영문자이면 
                String str = Character.toString(c1)+Character.toString(c2);
                String key = getEqualsKey(str);
                System.out.println(str);
                
                if(!key.equals("-")){ // 일치하는 요소가 있으면 
                    int cnt = map.get(key);
                    inter++;
                    if(cnt == 1){
                        map.remove(key);   
                    }else{
                        map.put(key, cnt-1);   
                    }
                }else{
                    total++;
                }
            }
        }
        
        getTotalCnt();
        total += inter;
        double answer = (double)inter/(double)total;
        if(inter == 0 && total == 0){
            answer = 1;
        }
        
        return (int)(answer * 65536);
    }
    
    static boolean checkChar(char c){
        //if(65 <= c && c <= 122){
        if(Character.toString(c).matches("^[a-zA-Z]*$")){
            return true;
        }
        
        return false;
    }
    
    static void getTotalCnt(){
        for(int num : map.values()){
            total += num;
        }
    }
    
    static String getEqualsKey(String str){
        for(String key : map.keySet()){
            if(key.equalsIgnoreCase(str)){
                return key;
            }
        }
        
        return "-";
    }
}

// 붙어있는 두 글자가 모두 영문자일 때만 원소로 추가(대소문자 구분없음)
// 자카드 유사도 = 교집합의 크기 / 합집합의 크기
// 1 1 2 2 3 / 1 2 2 4 5 = 1 1 2 2 3 4 5 => 교집합 + 여집합들 

// Map에 넣고, str2 넣을때 이미 있는 것이면 교집합 count하고, map에는 -1, 0이되면 빼기
// 마지막에 남은 요소들의 수를 합하면 여집합 