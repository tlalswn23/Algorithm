import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // A, B 최대공약수 구하기
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        
        boolean ab = divide(gcdA, arrayB);
        boolean ba = divide(gcdB, arrayA);
        
        if(ab){
            answer = gcdA;
        }
        
        if(ba){
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    static int gcd(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        return gcd(n2, n1%n2);
    }
    
    // true면 모두 나눌 수 없음 ==> 조건 만족 
    static boolean divide(int n, int[] arr){
        int cnt = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % n == 0){
                continue;
            }
            cnt++;
        }
        
        if(cnt == arr.length){
            return true;
        }
        return false;
    }
}