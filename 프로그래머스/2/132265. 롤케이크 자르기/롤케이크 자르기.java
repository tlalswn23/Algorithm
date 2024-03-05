import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> cake1 = new HashMap<>();
        Map<Integer, Integer> cake2 = new HashMap<>();
        int answer = 0;
        
        // map 초기화 
        cake1.put(topping[0], 1);
        
        for(int i = 1; i < topping.length; i++){
            int cnt = 1;
            if(cake2.containsKey(topping[i])){
                cnt += cake2.get(topping[i]);
            }
            
            cake2.put(topping[i], cnt);
        }
        
        // 롤케이크 자르기 
        for(int i = 1; i < topping.length; i++){
            if(cake1.size() == cake2.size()){ // 토핑 수가 같으면 ++
                answer++;
            }
            
            // i번째 토핑을 cake1에 추가하고 cake2에서는 제외하기
            int n1 = 1;
            if(cake1.containsKey(topping[i])){
                n1 += cake1.get(topping[i]);
            }
            cake1.put(topping[i], n1);
            
            int n2 = cake2.get(topping[i]);
            if(n2 == 1){
                cake2.remove(topping[i]);
            }else{
                n2--;
                cake2.put(topping[i], n2);
            }
        }
        
        return answer;
    }
}