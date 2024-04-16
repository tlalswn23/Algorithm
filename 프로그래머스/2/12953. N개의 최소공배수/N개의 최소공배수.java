import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int num = arr[arr.length-1];
        
        while(true){
            boolean check = true;
            
            for(int i = 0; i < arr.length; i++){
                if((num % arr[i]) != 0){
                    check = false;
                    break;
                }
            }
            
            if(check){
                answer = num;
                break;
            }
            
            num++;
        }
        
        return answer;
    }
}