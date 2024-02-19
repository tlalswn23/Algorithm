import java.util.*;

class Solution {
    static int total, b, y;
    
    public int[] solution(int brown, int yellow) {
        total = brown + yellow;
        b = brown;
        y = yellow;
        int start = total/2;
        
        int w = 0, h = 0;
        for(int i = start; i > 0; i--){
            if(total%i != 0){
                continue;
            }
            
            w = i;
            h = total/i;
            
            if(findCarpet(w, h)){
                break;
            }
        }
        
        return new int[] {w, h};
    }
    
    static boolean findCarpet(int w, int h){
        int border = w*2 + h*2 - 4;
        int inner = total - border;
        
        if(border == b && inner == y){
            return true;
        }
        
        return false;
    }
}