import java.util.*;

class Solution {
    static int B, Y;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        B = brown;
        Y = yellow;
        
        for(int i = 2; i <= (brown/2); i++){
            for(int j = 1; j <= i; j++){
                if(check(i, j)){
                    answer[0] = i;
                    answer[1] = j;
                    
                    return answer;
                }
            }
        }
        
        return answer;
    }
    
    static boolean check(int r, int c){
        // r, c일 때 수가 각 개수가 맞는지 확인
        int cntB = (r*2) + ((c-2)*2);
        int cntY = (r-2) * (c-2);
        
        if(cntB == B && cntY == Y){
            return true;
        }
        
        return false;
    }
}

// 가로의 최대 길이 : (타일 수) / 4
// 테두리 : (가로x2) + ((세로-2)x2)
// 가운데 : (가로-2) x (세로-2)