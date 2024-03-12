import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String temp = "";
        int cnt = 0;
        
        for(int i = 0; i <= t*m; i++){
            temp += Integer.toString(i, n);
        }
        
        for(int i = p-1; i < temp.length(); i+=m){
            if(cnt == t){
                break;
            }
            answer += temp.charAt(i);
            cnt++;
        }
        
        return answer.toUpperCase();
    }
}