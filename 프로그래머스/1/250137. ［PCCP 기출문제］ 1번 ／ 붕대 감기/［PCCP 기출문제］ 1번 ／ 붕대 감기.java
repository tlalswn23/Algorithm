import java.util.*;

class Solution {
    static int successTime; // 연속시간
    static int hp; // 현재 체력
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        hp = health - attacks[0][1];
        
        for(int i = 1; i < attacks.length; i++){
            if(hp < 0){
                return -1;
            }
            
            for(int j = attacks[i-1][0]+1; j < attacks[i][0]; j++){
                
                successTime++;
                if(successTime == bandage[0]){
                    hp = hp + bandage[2];
                    successTime = 0;
                }
                hp += bandage[1];
                
                if(hp > health){
                    hp = health;
                }
            }
            
            successTime = 0;
            hp -= attacks[i][1];
        }
        
        if(hp <= 0){
            hp = -1;
        }
        
        return hp;
    }
}