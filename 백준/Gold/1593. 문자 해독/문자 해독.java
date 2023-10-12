import java.util.*;
import java.io.*;

public class Main {
	static int g, s, result;
	static char[] str;
	static char[] W;
	static String S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		g = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		W = br.readLine().toCharArray();
		S = br.readLine();
		str = S.toCharArray();
		
		Map<Character, Integer> count = new HashMap<>();
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < g; i++) {
			if(count.get(W[i]) == null) {
				count.put(W[i], 1);				
			}else {				
				int temp = count.get(W[i]);
				count.put(W[i], temp+1);				
			}
			
			if(map.get(str[i]) == null) {
				map.put(str[i], 1);				
			}else {				
				int temp2 = map.get(str[i]);
				map.put(str[i], temp2+1);				
			}
		}
		
		boolean check = true;
		for(Character c : count.keySet()) {
			if(count.get(c) != map.get(c)) {
				check = false;
			}
		}
		
		if(check) {
			result++;
		}
	
		for(int i = 0; i < s-g; i++) {
			// i번째 문자의 카운트 -1하고 i+g의 문자를 +1
			
			// 앞에거 빼기 
			if(map.containsKey(str[i])) {
				int cnt = map.get(str[i]);
				map.put(str[i], cnt-1);				
			}
			
			// 뒤에거 넣기 
			if(map.containsKey(str[i+g])) {
				int n = map.get(str[i+g]);
				map.put(str[i+g], n+1);
			}else {
				map.put(str[i+g], 1);
			}
		
			
			// 맵의 값들이 같은지 비교해주기 
			check = true;
			for(Character c : count.keySet()) {
				if(count.get(c) != map.get(c)) {
					check = false;
				}
			}
			
			if(check) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
