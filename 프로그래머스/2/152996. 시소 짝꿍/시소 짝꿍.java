import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int cnt = 0;
        Arrays.sort(weights); // 오름차순 정렬 
        
        for(int i = 0; i < weights.length; i++){
            if(i > 0 && weights[i] == weights[i-1]){
                cnt--;
                answer += cnt;
                continue;
            }
            
            int index = findRange(i+1, weights[i], weights);
            cnt = 0;
            if(index >= weights.length){
                index = weights.length-1;
            }
            
            for(int j = i+1; j <= index; j++){
                if(checkDistance(weights[i], weights[j])){
                    cnt++;
                }
            }
            answer += cnt;
        }
        
        return answer;
    }
    
    // 처음으로 조건을 넘는 인덱스 반환 : 이분탐색 
    static int findRange(int i, int n, int[] weights){
        int left = i;
        int right = weights.length - 1;
        
        while(left < right){
            int mid = ((right - left) / 2) + left;
            if(weights[mid] > n * 2){
                return mid;
            }
            left = mid + 1;
        }
        
        return left;
    }
    
    // 균형을 이루는지 확인 
    static boolean checkDistance(int n1, int n2){
        if(n1 == n2){
            return true;
        }
        
        if(n1 * 3 == n2 * 2){
            return true;
        }
        
        if(n1 * 4 == n2 * 3){
            return true;
        }
        
        if(n1 * 4 == n2 * 2){
            return true;
        }
        
        return false;
    }
}