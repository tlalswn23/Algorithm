import java.util.*;

class Solution {
    static Queue<String> queue;
    static int min;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        queue = new LinkedList<>();
        visited = new boolean[words.length];
        
        for(String s : words){
            queue.add(s);
        }
        
        min = Integer.MAX_VALUE;
        wordChange(begin, 0, words, begin, target);
        
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        
        return min;
    }
    
    static void wordChange(String current, int count, String[] words, String begin, String target){
        
        if(current.equals(target)){
            min = Math.min(min, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            
            if(visited[i]){
                continue;
            }
            
            if(!checkWord(words[i], current)){
                continue;
            }
            
            visited[i] = true;
            wordChange(words[i], count+1, words, begin, target);
            visited[i] = false;
        }
    }
    
    // 하나만 다른 단어인지 검사 : 하나만 다른 단어이면 true 반환 
    static boolean checkWord(String current, String begin){
        int cnt = 0;
        
        for(int i = 0; i < current.length(); i++){
            if(begin.charAt(i) != current.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt == 1){
            return true;
        }
        
        return false;
    }
}