import java.util.*;

class Solution {
    public int[] solution(String s) {
        String str = s;
        int count = 0;
        int recur = 0;
        
        while(str.length() > 1){
            // 문자열에서 0을 제거하기
            int size = str.length();
            str = String.join("", str.split("0"));
            count += (size - str.length());
            
            // 길이를 2진수로 표현하기
            int number = str.length();
            str = Integer.toBinaryString(number);
            recur++;
        }
        
        return new int[] {recur, count};
    }
}

// 문자열에서 0을 제거하기
// 0을 제거하고 난 후의 길이를 2진수로 표현
// 1이 될 때까지 반복
// 반복 횟수와 제거된 0의 개수 반환