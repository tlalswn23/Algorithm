import java.util.*;

class Solution {
    static int[] num;
    static int N, answer;
    static boolean[] visited;
    static Set<Integer> numSet;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        num = new int[numbers.length()];
        N = numbers.length();
        numSet = new HashSet<>();
        
        for(int i = 0; i < numbers.length(); i++){
            num[i] = numbers.charAt(i) - '0';
        }
        
        Arrays.sort(num); // 정렬
        
        for(int i = 0; i < N; i++){
            visited[i] = true;
            findComb(Integer.toString(num[i]));
            visited[i] = false;
        }
        
        return answer;
    }
    
    static void findComb(String n){
        
        // 소수인지 확인 
        if(Integer.parseInt(n) != 1 && Integer.parseInt(n) != 0 && !numSet.contains(Integer.parseInt(n)) && checkPrime(n)){
            // System.out.println(n);
            numSet.add(Integer.parseInt(n));
            answer++;
        }
        
        if(n.length() == N){
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            findComb(n+num[i]);
            visited[i] = false;
        }
    }
    
    static boolean checkPrime(String n){
        int number = Integer.parseInt(n);
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }    
        }
        
        return true;
    }
}