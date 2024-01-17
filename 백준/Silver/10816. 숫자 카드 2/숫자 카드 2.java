
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] SG;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		SG = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			SG[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(SG); // 정렬 
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(getCardCount(n)));
			bw.write(" ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getCardCount(int n) {
		int lo = getLower(n);
		int hi = getUpper(n);
		
		return hi - lo;
	}

	static int getLower(int key) {
		int lo = 0;
		int hi = N;
		
		while(lo < hi) { // lo와 hi가 같아질 때까지 반복 
			int mid = (lo + hi) / 2;
			
			if(key <= SG[mid]) { // 중복원소일 경우 왼쪽 
				hi = mid;
			}
			
			if(key > SG[mid]) {
				lo = mid + 1;
			}
		}
		
		return lo;
	}
	
	static int getUpper(int key) {
		int lo = 0;
		int hi = N;
		
		while(lo < hi) {
			int mid = (lo+hi)/2;
			
			if(key >= SG[mid]) { // 중복원소일 경우 오른쪽 
				lo = mid+1;
			}
			
			if(key < SG[mid]) {
				hi = mid;
			}
		}
		
		return hi;
	}
}