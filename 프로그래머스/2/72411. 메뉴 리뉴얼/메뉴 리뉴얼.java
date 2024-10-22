import java.util.*;

class Solution {
    class Info{
        String c;
        int cnt;
        
        public Info(String c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static Map<String, Integer> dishes; // 코드에 다른 카운트 저장 
    static boolean[] visited;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = new String[100];
        int index = 0;
        dishes = new HashMap<>();
        
        for(int i = 0; i < orders.length; i++){
            visited = new boolean[orders[i].length()];
            findCourse(0, orders[i]);
        }
        
        // course 길이 중 가장 큰 값들만 추출
        for(int i = 0; i < course.length; i++){
            int size = course[i];
            List<Info> list = new ArrayList<>(); // 길이가 size인 요소만 저장 
            int max = 0;
            
            for(String s: dishes.keySet()){
                int count = dishes.get(s);
                if(s.length() == size && count > 1){
                    list.add(new Info(s, count));
                    max = Math.max(max, count);
                }
            }
            
            Collections.sort(list, (o1, o2) -> o2.cnt - o1.cnt); // 내림차순 저장
            for(int j = 0; j < list.size(); j++){
                Info element = list.get(j);
                if(max == element.cnt){
                    answer[index] = element.c;
                    index++;
                }
            }
        }
        
        answer = Arrays.copyOfRange(answer, 0, index);
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void findCourse(int index, String order){
        if(index == order.length()){
            char[] arr = getCourse(order).toCharArray();
            Arrays.sort(arr);
            
            String str = new String(arr);
            int cnt = 0;
            
            if(dishes.containsKey(str) && str.length() > 1){
                cnt = dishes.get(str);
            }
            dishes.put(str, cnt+1);
            return;
        }
        
        visited[index] = true;
        findCourse(index+1, order);
        visited[index] = false;
        findCourse(index+1, order);
    
    }
    
    static String getCourse(String order){
        String course = "";
        
        for(int i = 0; i < order.length(); i++){
            if(visited[i]){
                course += order.charAt(i);
            }
        }
        return course;
    }
}