import java.util.*;

class Solution {
    static Queue<int[]> range; // 행 시작, 행 끝, 열 시작, 열 끝
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        range = new LinkedList<>();
        range.add(new int[] {0, arr.length-1, 0, arr[0].length-1, arr.length});
        
        while(!range.isEmpty()){
            int[] check = range.poll();
            
            // 영역의 모든 요소가 일치하는 지 확인
            int num = checkArr(check[0], check[1], check[2], check[3], arr);
            //System.out.println(check[0]+ " "+check[1]+" "+check[2]+" "+check[3]);
            if(num != 2){ // 일치하면
                answer[num]++;
                continue;
            }
            
            if(check[4] == 1){
                continue;
            }
            
            // 모든 요소가 일치하지 않으면 네 구역으로 나눠서 큐에 다시 저장 
            range.add(new int[] {check[0], check[0] + check[4] / 2 - 1, check[2], check[2] + check[4] / 2 - 1, check[4] / 2});
            range.add(new int[] {check[0], check[0] + check[4] / 2 - 1, check[2] + check[4] / 2, check[3], check[4] / 2});
            range.add(new int[] {check[0] + check[4] / 2, check[1], check[2], check[2] + check[4] / 2 - 1, check[4] / 2});
            range.add(new int[] {check[0] + check[4] / 2, check[1], check[2] + check[4] / 2, check[3], check[4] / 2});
        }
        
        return answer;
    }
    
    static int checkArr(int rs, int re, int cs, int ce, int[][] arr){
        int n = arr[rs][cs];
        
        for(int i = rs; i <= re; i++){
            for(int j = cs; j <= ce; j++){
                if(arr[i][j] != n){
                    return 2;
                }
            }
        }
        
        return n;
    }
}