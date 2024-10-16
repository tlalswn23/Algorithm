import java.util.*;

class Solution {
    static Map<String, Integer> genreMap;
    static Map<String, List<int[]>> songMap;
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[genres.length];
        int count = 0;
        genreMap = new HashMap<>();
        songMap = new HashMap<>();
        
        
        // 전체 장르의 개수 카운트 + 장르에 따른 노래와 횟수 카운트
        for(int i = 0; i < genres.length; i++){
            int cnt = 0;
            List<int[]> songList = new ArrayList<>();
            
            if(genreMap.containsKey(genres[i])){
                cnt = genreMap.get(genres[i]);
                songList = songMap.get(genres[i]);
            }
            
            cnt += plays[i];
            genreMap.put(genres[i], cnt);
            songList.add(new int[] {i, plays[i]});
            songMap.put(genres[i], songList);
        }
        
        // 가장 많이 나온 장르 
        List<String> sortGenres = new ArrayList<>(genreMap.keySet()); // keyset 먼저 가져오기
        sortGenres.sort((o1, o2) -> genreMap.get(o2).compareTo(genreMap.get(o1)));
        
        for(int i = 0; i < sortGenres.size(); i++){
            List<int[]> list = songMap.get(sortGenres.get(i));
            Collections.sort(list, (o1, o2) -> o2[1] == o1[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
            // System.out.println(list.get(0)[0]+" "+list.get(0)[1]);
            
            
            int idx = 0;
            while(idx < list.size() && idx < 2){
                answer[count] = list.get(idx)[0];
                idx++;
                count++;
            }
        }
        
        
        return Arrays.copyOfRange(answer, 0, count);
    }
}