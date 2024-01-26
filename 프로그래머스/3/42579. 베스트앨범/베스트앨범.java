import java.util.*;

class Solution {
    class Song implements Comparable{
        int num, play;
        
        public Song(int num, int play){
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(Object o){
            Song other = (Song)o;
            return other.play - this.play;
        }
    }
    
    static Map<String, Integer> genreCnt;
    static Map<String, List<Song>> list;
    public int[] solution(String[] genres, int[] plays) {
        genreCnt = new HashMap<>();
        list = new HashMap<>();
        
        // 장르마다 총 재생 수 저장 + 리스트에 각 곡 고유번호, 재생 수 저장 
        for(int i = 0; i < plays.length; i++){
            int cnt = 0;
            List<Song> temp = new ArrayList<>();
            if(genreCnt.containsKey(genres[i])){
                cnt = genreCnt.get(genres[i]);
                temp = list.get(genres[i]);
            }
            
            genreCnt.put(genres[i], cnt+plays[i]);
            temp.add(new Song(i, plays[i]));
            list.put(genres[i], temp);
        }
        
        for(String s : list.keySet()){
            List<Song> temp = list.get(s);
            if(temp.size() > 1){
                Collections.sort(temp);
                list.put(s, temp);
            }
        }
        
        
        List<Map.Entry<String, Integer>> sortList = new LinkedList<>(genreCnt.entrySet());
        sortList.sort((o1, o2) -> o2.getValue() - o1.getValue()); // 내림차순 정렬
        
        
        int[] answer = new int[genres.length*2];
        int i = 0;
        
        // 많이 재생된 장르 순서대로 2곡씩 저장 
        for(Map.Entry<String, Integer> s : sortList){
            // 해당 장르에 대해 
            String genre = s.getKey();
            List<Song> temp = list.get(genre);
            int size = temp.size();
            
            // list 길이가 2이상이면 2까지 돌고 2이하이면 길이까지.
            if(temp.size() > 2){
                size = 2;
            }
            
            for(int j = 0; j < size; j++){
                answer[i] = temp.get(j).num;
                i++;
            }
        }
        
        return Arrays.copyOfRange(answer, 0, i);
    }
}