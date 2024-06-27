
import java.util.*;
import java.io.*;

public class Main {
	static int N, M, total;
	static int[] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1; i < M-1; i++) {
			int left = 0;
			int right = 0;
			
			// 왼쪽에서 가장 높은 곳
			for(int l = i-1; l >= 0; l--) {
				left = Math.max(left, map[l]);
			}
			
			// 오른쪽에서 가장 높은 곳
			for(int r = i+1; r < M; r++) {
				right = Math.max(right, map[r]);
			}
			
			// 둘 중 더 낮은 곳만큼 채울 수 있음 
			if(map[i] < left && map[i] < right) {
				total += Math.min(left, right) - map[i];
			}
		}
		
		bw.write(Integer.toString(total));
		bw.close();
	}
}
