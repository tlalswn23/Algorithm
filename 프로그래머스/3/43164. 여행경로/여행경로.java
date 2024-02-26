import java.util.*;

class Solution {
    static class Info{
        boolean visited;
        String name;
        
        public Info(String name, boolean visited){
            this.name = name;
            this.visited = visited;
        }
    }
    
    static Map<String, List<Info>> airport;
    static String[] answer;
    static int size;
    static boolean check;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        airport = new HashMap<>();
        size = tickets.length;
        
        for(int i = 0; i < tickets.length; i++)
        {
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            // 시작 
            if(airport.containsKey(start)){
                List<Info> list = airport.get(start);
                list.add(new Info(end, false));
                airport.put(start, list);
            }else{
                List<Info> list = new ArrayList<>();
                list.add(new Info(end, false));
                airport.put(start, list);
            }
        }        

        String[] route = new String[size+1];
        route[0] = "ICN";
        flyRoute(1, "ICN", route);
        
        return answer;
    }
    
    static void flyRoute(int n, String name, String[] route){
        if(check){
            return;
        }
        
        if(n == size+1){ // 모든 공항을 다 방문했으면 멈춤 
            for(int i = 0; i < size+1; i++){
                // System.out.print(route[i]+" ");
                answer[i] = route[i];
            }
            // System.out.println();
            
            check = true;
            return;
        }
        
        if(airport.containsKey(name)){ // 방문할 수 있는 공항이 있으면 
            List<Info> list = airport.get(name);
            Collections.sort(list, (o1, o2) -> o1.name.compareTo(o2.name));
            
            for(int i = 0; i < list.size(); i++){ // 해당 공항에서 갈 수 있는 공항 가보기 
                Info info = list.get(i);
                
                // 방문했으면 넘어가기 
                if(info.visited){
                    continue;
                }
                
                // 방문 처리 
                info.visited = true;
                list.set(i, info);
                airport.put(name, list);
                
                route[n] = list.get(i).name;
                flyRoute(n+1, list.get(i).name, route);
                
                // 방문 처리 복구
                info.visited = false;
                list.set(i, info);
                airport.put(name, list);
                
            }
        }
    }
}

// 항공권을 모두 사용해야 함 
// 재귀 -> 모든 항공 개수 다 방문했으면 종료
// 알파벳 순 
// 여러번 나올 수 있으니까 set은 안됨 