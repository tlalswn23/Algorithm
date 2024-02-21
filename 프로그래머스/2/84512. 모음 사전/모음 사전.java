import java.util.*;

class Solution {
    static int answer, cnt;
    static boolean check;
    static char[] key = {'A' , 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        
        findIndex("", word, 0);
        
        return answer;
    }
    
    static void findIndex(String str, String word, int index){
        if(check){
            return;
        }
        
        if(str.equals(word)){
            check = true;
            answer = cnt;
            return;
        }
        
        if(index == 5){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            cnt++;
            findIndex(str+key[i], word, index+1);
        }
    }
}