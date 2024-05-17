import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int index = 0;
        List<Integer> list = new ArrayList<>();
        
        long fact = 1;
        for(int i = 1; i < n+1; i++){
            list.add(i);
            fact *= i;
        }
        
        k--;
        
        while(n > 0){
            fact /= n;
            
            int num = (int) (k / fact);
            answer[index] = list.get(num);
            list.remove(num);
            
            k = k % fact;
            index++;
            n--;
        }
        
        return answer;
    }
}