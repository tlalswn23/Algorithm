

import java.util.*;
import java.io.*;

public class Main {
	static Map<Character, Integer> cnt;
	static int min, max, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			cnt = new HashMap<>();
			min = str.length();
			max = 0;
			
			for(int i = 0; i < str.length(); i++) { // 문자열에 사용된 총 개수 저장 
				char c = str.charAt(i);
				int count = 1;
				
				if(cnt.containsKey(c)) {
					count += cnt.get(c);
				}
				
				cnt.put(c, count);
			}
			
			K = Integer.parseInt(br.readLine());
			
			// K개 이상인 것만 확인
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(cnt.get(c) < K) { // 문자열에 포함된 총 개수가 작으면 확인하지 않음
					continue;
				}
				
				findStr(str, i);
			}
			
			if(min == str.length() && max == 0) {
				bw.write("-1\n");
				continue;
			}
			
			bw.write(Integer.toString(min)+" "+Integer.toString(max)+"\n");
		}
		
		bw.close();
	}
	
	static void findStr(String str, int index) {
		int right = index;
		int count = 0;
		
		while(right < str.length()) {
			if(str.charAt(right) == str.charAt(index)) {
				count++;
				
				if(count == K) {
					min = Math.min(min, right - index + 1);
					max = Math.max(max, right - index + 1);
					return;
				}
			}
			
			right++;
		}
	}
}
