import java.util.*;

class Solution {
    static Map<String, Integer> product;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int left = 1, right = 10;
        product = new HashMap<>();
        
        // map에 초기화 
        for(int i = 0; i < want.length; i++){
            int cnt = number[i];
            if(product.containsKey(want[i])){
                cnt += product.get(want[i]);
            }
            
            product.put(want[i], cnt);
        }
        
        for(int i = 0; i < 10; i++){
            if(product.containsKey(discount[i])){
                int cnt = product.get(discount[i]);
                product.put(discount[i], cnt-1);
            }
        }
        
        if(countCheck(want)){
            answer++;
        }
        
        while(right < discount.length){
            
            // left : 이전 거 더해주기 
            int cnt = 1;
            if(product.containsKey(discount[left-1])){
                cnt += product.get(discount[left-1]);
            }
            product.put(discount[left-1], cnt);
            
            // right : 다음 거 빼주기 
            if(product.containsKey(discount[right])){
                int cnt2 = product.get(discount[right]);
                product.put(discount[right], cnt2-1);
            }
            
            if(countCheck(want)){
                answer++;
            }
            
            left++; right++;
        }
        
        return answer;
    }
    
    static boolean countCheck(String[] want){
        for(int i = 0; i < want.length; i++){
            if(product.get(want[i]) > 0){
                return false;
            }
        }
        
        return true;
    }
}