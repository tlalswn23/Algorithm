import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String temp1 = s.substring(2, s.length()-2);
        String temp2 = Arrays.toString(temp1.split("\\},\\{"));
        String[] str = temp2.split("\\s|,|\\]|\\[");
        
        for(int i = 0; i < str.length; i++){
            if(str[i] == " "){
                continue;
            }
            
            if(!map.containsKey(str[i])){
                map.put(str[i], 1);
                continue;
            }
            
            int cnt = map.get(str[i]);
            map.put(str[i], cnt+1);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); // 해시맵 리스트로 추출
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue())); // 리스트 내림차순 정렬
        
        int[] answer = new int[list.size()-1];
        // 가장 많이 나온 순서대로 출력
        for(int i = 1; i < list.size(); i++){
            answer[i-1] = Integer.parseInt(list.get(i).getKey());
        }
        
        return answer;
    }
}

// 튜플을 찾는 문제
// 그냥 숫자만 체크하면 될 듯?
// Map에 넣고 가장 많이 나온 순으로 출력?