import java.util.*;
import java.io.*;

public class Main {
	
	static LinkedHashMap<String, List<Integer>> prefix;
	static int N;
	static String[] word;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		word = new String[N];
		prefix = new LinkedHashMap<>();
		
		for(int i = 0; i < N; i++) {
			word[i] = br.readLine();
			
			// 가능한 모든 접두사 등록 
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < word[i].length(); j++) {
				sb.append(word[i].charAt(j));
				
				if(!prefix.containsKey(sb.toString())) {
					prefix.put(sb.toString(), new ArrayList<>());
				}
				
				prefix.get(sb.toString()).add(i);
			}
		}
		
		// 맵을 돌면서 list 크기가 2이상인 가장 큰 접두사 찾기
		String prefixWord = "";
		int max = -1;
		
		for(String pre : prefix.keySet()) {
			List<Integer> list = prefix.get(pre);
			
			if(list.size() >= 2 && max < pre.length()) {
				max = pre.length();
				prefixWord = pre;
			}
		}
		
		if(max == -1) {
			bw.write(word[0]);
			bw.write(word[1]);
		}
		else {
			// 가장 큰 접두사에 가장 먼저, 다음으로 등록된 단어 출력
			bw.write(word[prefix.get(prefixWord).get(0)]+"\n");
			bw.write(word[prefix.get(prefixWord).get(1)]+"\n");			
		}
		
		bw.close();
		br.close();
	}

}
