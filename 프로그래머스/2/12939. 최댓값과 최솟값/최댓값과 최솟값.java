import java.util.*;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] arr = s.split(" ");
        
        for(int i = 0; i < arr.length; i++){
            min = Math.min(min, Integer.parseInt(arr[i]));
            max = Math.max(max, Integer.parseInt(arr[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min+" ");
        sb.append(max);
        
        return sb.toString();
    }
}