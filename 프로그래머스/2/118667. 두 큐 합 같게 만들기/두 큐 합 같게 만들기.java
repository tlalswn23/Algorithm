import java.util.*;

class Solution {
    static long total, target, count;
    static int[] queue;
    
    public long solution(int[] queue1, int[] queue2) {
        long sum = 0;
        queue = new int[queue1.length*2];
        
        for(int i = 0; i < queue1.length; i++){
            queue[i] = queue1[i];
            total += queue1[i];
            sum += queue1[i];
        }
        
        for(int i = 0; i < queue1.length; i++){
            queue[i+queue1.length] = queue2[i];
            total += queue2[i];
        }
        
        target = total / 2;
        
        int left = 0;
        int right = queue1.length;
        
        while(left < right && right < queue.length){
            
            if(sum == target){
                return count;
            }
            
            if(sum < target){
                sum += queue[right];
                right++;
                count++;
                continue;
            }
            
            if(sum > target){
                sum -= queue[left];
                left++;
                count++;
            }
        }
        
        
        return -1;
    }
}