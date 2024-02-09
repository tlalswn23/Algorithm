import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int size = number.length();
        int[] numArr = new int[size];
        
        // 숫자 배열에 저장 
        for(int i = 0; i < size; i++){
            numArr[i] = number.charAt(i) - '0';
        }
        
        int max = 0;
        int maxIdx = 0;
        // 가장 첫 번째 자리 찾기 
        for(int i = 0; i <= k; i++){
            if(numArr[i] > max){
                max = numArr[i];
                maxIdx = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = maxIdx; i < size; i++){
            sb.append(numArr[i]);
        }
        
        int cnt = maxIdx;
        int index = 1;
        while(cnt < k){
            boolean check = true;
            for(int j = index; j < sb.length(); j++){
                if(sb.charAt(j) > sb.charAt(j-1)){
                    sb.deleteCharAt(j-1);
                    cnt++;
                    check = false;
                    index = j-1;
                    break;
                }
            }
            
            if(check){
                break;
            }
        }
        
        answer = sb.toString();
        
        if(cnt < k){
            answer = sb.substring(0, sb.length()-(k-cnt));  
        }
        
        return answer;
    }
}