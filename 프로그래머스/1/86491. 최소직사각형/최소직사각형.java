import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int mh = 0;
        int mw = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int h = 0, w = 0;
            
            // 가로 세로 찾기 
            if(sizes[i][0] < sizes[i][1]){
                h = sizes[i][0];
                w = sizes[i][1];
            }else{
                h = sizes[i][1];
                w = sizes[i][0];
            }
            
            // max값 갱신 
            mh = Math.max(mh, h);
            mw = Math.max(mw, w);
            
        }
        
        return mh * mw;
    }
}