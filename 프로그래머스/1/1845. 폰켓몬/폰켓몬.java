import java.util.*;

class Solution {
    static int target;
    static Map<Integer, Integer> map;
    
    public int solution(int[] nums) {
        int answer = 0;
        target = nums.length/2;
        map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int cnt = 0;
            if(map.containsKey(nums[i])){
                cnt = map.get(nums[i]);
            }
            
            map.put(nums[i], cnt+1);
        }
        
        int size = map.size();
        if(size >= target){
            answer = target;
        }
        
        if(size < target){
            answer = size;
        }
        
        return answer;
    }
}