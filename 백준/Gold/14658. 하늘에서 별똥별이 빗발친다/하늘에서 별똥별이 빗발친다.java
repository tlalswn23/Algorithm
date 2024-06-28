
import java.util.*;
import java.io.*;

public class Main {
	static int N, M, L, K, min;
	static int[][] map;
	static List<int[]> stars;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stars = new ArrayList<>();
		min = K;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars.add(new int[] {x, y});
		}
		
		for(int i = 0; i < stars.size(); i++) {
			for(int j = 0; j < stars.size(); j++) {
				int[] s1 = stars.get(i);
				int[] s2 = stars.get(j);
				
				int cnt = countStar(new int[] {s1[0], s2[1]});
				min = Math.min(min, K - cnt);
			}
		}
		
		bw.write(Integer.toString(min));
		bw.close();
	}
	
	static int countStar(int[] pos) {
		int cnt = 0;
		
		for(int i = 0; i < stars.size(); i++) {
			
			// 범위안에 들어가는 지 확인
			int[] current = stars.get(i);
			if(current[0] < pos[0] || current[0] > pos[0]+L+1 
					|| current[1] < pos[1] || current[1] > pos[1]+L+1) {
				continue;
			}
			
			cnt++;
		}
		
		return cnt;
	}
}
