import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length-1;
        
        if(people.length == 1){
            return 1;
        }
        
        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
        Collections.sort(list);
        Integer[] newList = list.toArray(new Integer[list.size()]);
        
        while(left < right){
            answer++;
            if(newList[left] + newList[right] <= limit){
                left++;
            }
            right--;
        }
        
        if(left == right){
            answer++;
        }
        
        return answer;
    }
}