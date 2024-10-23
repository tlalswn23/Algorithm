import java.util.*;

class Solution {
    static int[] integral;
    static double[] extent;
    static int index = 1;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        integral = new int[20000];
        
        getIntegral(k); // 우박수열 구하기
        
        // 모든 구간에 대한 정적분 구하기
        extent = new double[index+1];
        for(int i = 0; i < index-1; i++){
            int max = Math.max(integral[i], integral[i+1]);
            int min = Math.min(integral[i], integral[i+1]);
            extent[i+1] = extent[i] + min + ((double)(max-min) / 2);
            // System.out.println(extent[i+1]);
        }
        
        // 주어진 구간에 대한 넓이 합 구하기
        for(int i = 0; i < ranges.length; i++){
            int x1 = ranges[i][0];
            int x2 = (index-1) - Math.abs(ranges[i][1]);
            
            // System.out.println(x1+" "+x2);
            if(x1 == x2){
                answer[i] = 0.0;
            }else if(x1 < x2){
                answer[i] = extent[x2] - extent[x1];
            }else{
                answer[i] = -1.0;
            }
        }

        return answer;
    }
    
    // 우박수열 구하기
    static void getIntegral(int k){
        int num = k;
        integral[0] = k;
        
        while(num > 1){
            if(num % 2 == 0){
                num /= 2;
            }else{
                num *= 3;
                num++;
            }
            integral[index] = num;
            index++;
        }
        
        integral = Arrays.copyOfRange(integral, 0, index);
    }
}