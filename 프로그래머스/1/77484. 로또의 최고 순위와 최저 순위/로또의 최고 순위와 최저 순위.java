import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zero = 0;
        boolean check = false;
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        Set<Integer> lottoNum = new HashSet<>();
        
        // set에 정답 저장 
        for(int i = 0; i < 6; i++){
            lottoNum.add(win_nums[i]);
        }
        
        // 정렬
        Arrays.sort(lottos);
        
        for(int i = 5; i >= 0; i--){
            if(lottos[i] == 0){
                zero++;
            }
            
            if(lottoNum.contains(lottos[i])){ // 로또 번호와 일치하면 
                cnt++;
            }
        }
        
        return new int[] {rank[cnt+zero], rank[cnt]};
    }
}