import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] n1 = new String[arr1.length];
        String[] n2 = new String[arr2.length];
        
        for(int i = 0; i < n; i++){
            n1[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            n2[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
        }
        
        for(int i = 0; i < n; i++){
            String temp = "";
            for(int j = 0; j < n; j++){
                if(n1[i].charAt(j) == '1' || n2[i].charAt(j) == '1'){
                    temp += "#";
                    continue;
                }
                
                temp += " ";
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}