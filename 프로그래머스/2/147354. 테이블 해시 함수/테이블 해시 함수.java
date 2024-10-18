import java.util.*;

class Solution {
    static List<int[]> table;
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[] S = new int[row_end - row_begin+1];
        table = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++){
            table.add(data[i]);
        }

        Collections.sort(table, (o1, o2) -> o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);
        
        int size = row_end - row_begin + 1;
        
        for(int i = 0; i < size; i++){
            int[] current = table.get(i+row_begin-1);
            
            // 각 요소에 대해 mod 연산 
            for(int j = 0; j < current.length; j++){
                S[i] += (current[j] % (i+row_begin));
                
            }
        }
        
        for(int i = 0; i < size; i++){
            answer ^= S[i];
        }
        
        return answer;
    }
}