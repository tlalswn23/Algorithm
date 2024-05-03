import java.util.*;

class Solution {
    static int extOption, sortOption;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new LinkedList<>();
        setOption(ext, sort_by);
    
        for(int i = 0; i < data.length; i++){
            if(data[i][extOption] > val_ext){
                continue;
            }
            
            list.add(data[i]);
        }
        
        Collections.sort(list, (o1, o2) -> o1[sortOption] - o2[sortOption]);
        
        return list.toArray(new int[list.size()][4]);
    }
    
    static void setOption(String ext, String sort_by){
        if(ext.equals("code")){
            extOption = 0;
        }
        
        if(ext.equals("date")){
            extOption = 1;
        }
        
        if(ext.equals("maximum")){
            extOption = 2;
        }
        
        if(ext.equals("remain")){
            extOption = 3;
        }
        
        if(sort_by.equals("code")){
            sortOption = 0;
        }
        
        if(sort_by.equals("date")){
            sortOption = 1;
        }
        
        if(sort_by.equals("maximum")){
            sortOption = 2;
        }
        
        if(sort_by.equals("remain")){
            sortOption = 3;
        }
    }
}