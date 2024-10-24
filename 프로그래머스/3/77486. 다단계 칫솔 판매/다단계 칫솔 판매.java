import java.util.*;

class Solution {
    static Map<String, String> linked;
    static Map<String, Integer> index;
    static int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        linked = new HashMap<>();
        index = new HashMap<>();
        
        // 연결관계 저장 
        for(int i = 0; i < enroll.length; i++){
            linked.put(enroll[i], referral[i]);
            index.put(enroll[i], i); // 어떤 사람이 몇 번인지 저장
        }
        
        // 각 수익에 대한 분배 
        for(int i = 0; i < seller.length; i++){
            int totalProfit = amount[i]*100; // 수익
            calcProfit(seller[i], totalProfit);
        }
        
        return answer;
    }
    
    // 재귀함수를 통해 수익 분배 하는 함수
    static void calcProfit(String name, int profit){
        if(profit == 0){
            return;
        }
        
        if(name.equals("-")){ // 루트에 도달하면 리턴 
            return;
        }
        
        int fee = (int)(profit * 0.1);
        
        // 90% 저장하고, 10% 다음으로 넘기기
        answer[index.get(name)] += profit - fee;
        calcProfit(linked.get(name), fee);   
    }
}