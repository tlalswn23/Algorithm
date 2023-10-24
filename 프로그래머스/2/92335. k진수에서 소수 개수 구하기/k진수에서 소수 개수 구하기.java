import java.util.*;

class Solution {
    static int count;
    
    public int solution(int n, int k) {
        String number = Integer.toString(n, k); // k진수 변환 
        char[] arr = number.toCharArray();
        String temp = "";
    
        
        for(Character c : arr){
            if(c == '0'){
                if(!temp.equals("")){
                    checkPrime(Long.parseLong(temp));
                }
                
                temp = "";
                continue;
            }
        
            temp += c;
        }
        
        if(!temp.equals("")){
            checkPrime(Long.parseLong(temp));
        }
        
        return count;
    }
    
    // 소수 찾는 함수 
    static void checkPrime(long n){
        if(n == 1){
            return; 
        }

        for(int i = 2; i <= Math.sqrt(n); i++){
            if((n % i) == 0){
                return;
            }
        }
        
        count++;
        return;
    }
}