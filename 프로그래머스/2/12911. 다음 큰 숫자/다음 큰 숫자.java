import java.util.*;

class Solution {
    public int solution(int n) {
        String toBinary = Integer.toBinaryString(n);
        int cnt = 0;
        int m = n+1;
        
        for(int i = 0; i < toBinary.length(); i++){
            if(toBinary.charAt(i) == '1'){
                cnt++;
            }
        }
        
        while(true){
            if(cnt == checkNumber(m)){
                break;
            }
            m += 1;
        }
        
        return m;
    }
    
    static int checkNumber(int m){
        String temp = Integer.toBinaryString(m);
        int count = 0;
        
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '1'){
                count++;
            }
        }
        
        return count;
    }
}