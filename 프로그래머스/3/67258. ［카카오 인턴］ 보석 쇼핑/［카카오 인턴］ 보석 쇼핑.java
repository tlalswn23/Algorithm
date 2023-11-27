import java.util.*;

class Solution {
    static Set<String> name;
    static int start, end;
    
    public int[] solution(String[] gems) {
        name = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            name.add(gems[i]);
        }
        
        Map<String, Integer> jewelry = new HashMap<>(); 
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        
        while(left <= right && right < gems.length){
            // 보석 카운트 추가 
            if(jewelry.containsKey(gems[right])){
                int cnt = jewelry.get(gems[right]);
                jewelry.put(gems[right], cnt+1);
            }else{
                jewelry.put(gems[right], 1);
            }
            
            while(jewelry.size() == name.size()){ // 모든 보석을 포함하면 반복
                // 1. min 값 보다 작으면 좌표 갱신 
                if(min > (right - left)){
                    min = right - left;
                    start = left+1;
                    end = right+1;
                }
                
                // 2. left++(left 자리의 count -1 해주기 )
                int cnt = jewelry.get(gems[left]);
                if(cnt == 1){ // 만약 1개 남았으면 맵에서 제거
                    jewelry.remove(gems[left]);
                }else{
                    jewelry.put(gems[left], cnt-1);
                }
                left++;
            }
            
            right++;
        }
        
       
        return new int[] {start, end};
    }
}

// answer : 모든 종류의 보석을 1개 이상 포함하는 가장! 짧은! 구간
// 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간