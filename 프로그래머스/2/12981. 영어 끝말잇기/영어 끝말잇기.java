import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> wordSet = new HashSet<>();
        
        int index = 0;
        int count = 1;
        char c = words[0].charAt(0);
        while(index < words.length){
            for(int i = 1; i <= n; i++){
                String word = words[index];
                
                // 1. 한 글자인 단어는 안됨
                if(word.length() == 1){
                    return new int[] {i, count};
                }
                
                // 2. 이전 단어의 마지막 글자와 첫글자가 다르면 안됨
                if(c != word.charAt(0)){
                    return new int[] {i, count};
                }
                
                // 3. 이전에 나왔던 단어면 안됨
                if(wordSet.contains(word)){
                    return new int[] {i, count};
                }
                
                wordSet.add(word);
                c = word.charAt(word.length()-1);
                index++;
            }
            count++;
        }
        
        return answer;
    }
}