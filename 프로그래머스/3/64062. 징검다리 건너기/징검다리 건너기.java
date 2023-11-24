class Solution {
    static int answer;
    public int solution(int[] stones, int k) {
    
        int left = 0, right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(checkStones(stones, k, mid)){ // 건널 수 있음
                answer = mid;
                left = mid+1;
            }
            else{ // 건널 수 없음 
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    // M보다 작은 수는 0으로 처리 
    // 0이 K개면 건널 수 없음, K개보다 적으면 건널 수 있음 
    static boolean checkStones(int[] stones, int k, int M){
        int count = 0;
        
        for(int i = 0; i < stones.length; i++){
            if(stones[i] >= M){ // M보다 크면 패스
                count = 0;
                continue;
            }
            
            if(stones[i] < M){
                count++;
                if(count == k){
                    return false;
                }
            }
        }
        
        return true;
    }
}