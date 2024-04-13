
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static Map<String, Integer> words; // 단어의 등장 횟수 저장 
	
	static class Word implements Comparable<Word>{
		String word;
		int count, length;
		
		public Word(String word, int count, int length) {
			this.word = word;
			this.count = count;
			this.length = length;
		}

		@Override
		public int compareTo(Word o) {
			// TODO Auto-generated method stub
			if(this.count > o.count) { // 내림차순 
				return -1;
			}else if(this.count == o.count) {
				if(this.length > o.length) {
					return -1;
				}else if(this.length == o.length) {
					return this.word.compareTo(o.word);					
				}
			}
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new HashMap<>();
		List<Word> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.length() < M) {
				continue;
			}
			
			int cnt = 1;
			
			if(words.containsKey(str)) {
				cnt += words.get(str);
			}
			
			words.put(str, cnt);
		}
		
		// 리스트에 저장 
		for(String s : words.keySet()) {
			list.add(new Word(s, words.get(s), s.length()));
		}
		
		Collections.sort(list);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < list.size(); i++) {
			bw.write(list.get(i).word+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
