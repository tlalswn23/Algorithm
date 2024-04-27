import java.util.*;

class Solution {
    static int[] discount = {40, 30, 20, 10};
    static int size;
    static int[] dis;
    static int[][] userArr;
    static int[] emot;
    static int[] answer;
    
    public int[] solution(int[][] users, int[] emoticons) {
        size = emoticons.length;
        dis = new int[size];
        userArr = new int[users.length][users[0].length];
        emot = new int[emoticons.length];
        answer = new int[2];
        
        for(int i = 0; i < users.length; i++){
            for(int j = 0; j < users[i].length; j++){
                userArr[i][j] = users[i][j];
            }
        }
        
        for(int i = 0; i < emoticons.length; i++){
            emot[i] = emoticons[i];
        }
        
        comb(0);
        return answer;
    }
    
    static void comb(int n){
        if(n == size){
            int[] result = buyEmoticons();
            updateResult(result);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            dis[n] = discount[i];
            comb(n+1);
        }
    }
    
    static int[] buyEmoticons(){
        int total = 0;
        int plus = 0;
        
        // 각 사용자별 구매 금액 구하기 
        for(int i = 0; i < userArr.length; i++){
            int sum = 0;
            int disMin = userArr[i][0];
            
            for(int j = 0; j < size; j++){
                if(disMin > dis[j]){ // 할인 조건보다 할인이 작으면 구매안함
                    continue;
                }
                
                sum = sum + (emot[j] * (100 - dis[j]) / 100);
            }
            
            // 금액 조건보다 작으면 이모티콘 구매, 크면 이모티콘 플러스 가입
            if(sum < userArr[i][1]){
                total += sum;
                continue;
            }
            
            plus++;
        }
        
        return new int[] {plus, total};
    }
    
    static void updateResult(int[] result){
        // 이모티콘 플러스 가입이 많고, 판매 금액이 높은 결과로 갱신
        
        if(result[0] > answer[0]){
            answer[0] = result[0];
            answer[1] = result[1];
            return;
        }
        
        if(result[0] == answer[0]){
            if(result[1] > answer[1]){
                answer[0] = result[0];
                answer[1] = result[1];
                return;
            }
        }
    }
    
    static void printArr(){
        for(int i = 0; i < size; i++){
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }
}