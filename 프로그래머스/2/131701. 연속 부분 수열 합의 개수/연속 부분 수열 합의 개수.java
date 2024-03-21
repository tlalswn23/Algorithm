import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++){ // 모든 원소가 시작 원소가 될 수 있도록 반복
            int sum = 0;
            int index = i;
            int count = 0;
            
            while(count < elements.length){
                sum += elements[index];
                sumSet.add(sum);
                index++;
                if(index == elements.length){
                    index = 0;
                }
                count++;
            }
        }
        
        return sumSet.size();
    }
}