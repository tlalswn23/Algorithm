import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        answer = sb.toString();
        
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}
// import java.util.*;

// class Solution {
//     public String solution(int[] numbers) {
//         String answer = "";

//         String[] str = new String[numbers.length];
//         for(int i = 0; i < numbers.length; i++){
//             str[i] = Integer.toString(numbers[i]);
//         }
        
//         Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
//         if(str[numbers.length-1].equals("0")){
//             return "0";
//         }
        
//         for(int i = 0; i < numbers.length; i++){
//             answer += str[i];
//         }
        
//         return answer;
//     }
    
//     static int maxNumber(int i, int j, String[] str){
//         String num1 = str[i];
//         String num2 = str[j];
        
//         if(Integer.parseInt(num1+num2) > Integer.parseInt(num2+num1)){
//             return i;
//         }
        
//         return j;
//     }
// }