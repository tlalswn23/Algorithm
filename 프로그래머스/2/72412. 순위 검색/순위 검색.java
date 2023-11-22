import java.util.*;

class Solution {
    static Map<String, List<Integer>> applicants;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        applicants = new HashMap<>();
        
        // key는 점수, value는 조건으로 map에 저장
        for(int i = 0; i < info.length; i++){
            String[] parseStr = info[i].split(" ");
            putIntoMap(0, "", parseStr);
        }
        
        for(String s : applicants.keySet()){
            List<Integer> list = applicants.get(s);
            Collections.sort(list);
            applicants.put(s, list);
        }
        
        // query 처리 
        for(int i = 0; i < query.length; i++){
            String[] temp = query[i].split(" and ");
            String[] s = temp[3].split(" ");
            String str = temp[0]+temp[1]+temp[2]+s[0];
            int score = Integer.parseInt(s[1]);
            int count = 0;
            
            List<Integer> scoreList = applicants.get(str);
            if(!applicants.containsKey(str)){
                scoreList = new ArrayList<>();
                scoreList.add(0);
            }
            
            int start = lowerBound(scoreList, score);
            count = scoreList.size() - start;
            
            answer[i] = count;
        }
        
        return answer;
    }
    
    static void putIntoMap(int n, String str, String[] temp){
        if(n == 4){
            
            List<Integer> list = null;
            if(!applicants.containsKey(str)){
                list = new ArrayList<>();
            }
            else{
                list = applicants.get(str);
            }
            list.add(Integer.parseInt(temp[4]));
            applicants.put(str, list);
            return;
        }
        
        putIntoMap(n+1, str+"-", temp);
        putIntoMap(n+1, str+temp[n], temp);
        
    }
    
    static int lowerBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();
        
        while(left < right){
            
            int mid = (right+left)/2;
            if(list.get(mid) >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        return right;
    }
}