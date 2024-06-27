
import java.util.*;
import java.io.*;

public class Main {
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] building = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			
			if(i != 0) {
				// 왼쪽
				double l = (double)(building[i] - building[i-1]);
				cnt++;
				
				for(int j = i-2; j >= 0; j--) {
					double n = (double)(building[i] - building[j]) / (i - j);
					
					if(l > n) {						
						l = n;
						cnt++;
					}
				}				
			}
			
			if(i != N-1) {
				// 오른쪽
				double r = (double)(building[i] - building[i+1]) / (-1);
				cnt++;
					
				for(int j = i+2; j < N; j++) {
					double n = (double)(building[i] - building[j]) / (i - j);
					
					if(r < n) {
						r = n;
						cnt++;
					}
				}				
			}

			max = Math.max(cnt,  max);
		}
		
		bw.write(Integer.toString(max));
		bw.close();
	}
}
