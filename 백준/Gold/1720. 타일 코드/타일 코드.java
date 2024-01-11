
import java.io.*;

public class Main {
	static int N;
	static int[] tile;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tile = new int[N+1];
		
		int result = 0;
		
		tile[0] = 1;
		tile[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			tile[i] = tile[i-1] + tile[i-2] * 2;
		}
		
		if(N % 2 == 0) { // 짝	
			result = (tile[N] + tile[N/2] + tile[(N-2)/2]*2) / 2;
		}
		
		if(N % 2 == 1) { // 홀 
			result = (tile[N] + tile[(N-1)/2]) / 2;
		}
		
		System.out.println(result);
	}
}
