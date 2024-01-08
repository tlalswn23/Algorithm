
import java.util.*;
import java.io.*;

public class Main {
	static int N, min, total;
	static int[] d, w; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		d = new int[N-1];
		w = new int[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		
		min = Integer.MAX_VALUE; // 초기화 
		for(int i = 0; i < N-1; i++) {
			if(min >= w[i]) { // min 값과 같거나 작으면 min 값을 갱신
				min = w[i];
			}
			
			total += d[i]*min;
		}
		
		System.out.println(total);
	}

}