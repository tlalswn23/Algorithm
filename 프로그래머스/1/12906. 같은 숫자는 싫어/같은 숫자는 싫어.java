import java.util.*;

public class Solution {
    
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int size = 1;
        answer[0] = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if(answer[size-1] != arr[i]){
                answer[size] = arr[i];
                size++;
                continue;
            }
        }

        return Arrays.copyOfRange(answer, 0, size);
    }
}
/*
스택에 넣되 peek 한 수와 현재 넣으려는 수가 같으면 다음으로, 수가 다르면 넣기 
*/