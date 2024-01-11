
import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static List<Integer> coin;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new ArrayList<>();
		dp = new int[k+1];
		
		for(int i = 0; i < n; i++) {
			coin.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(coin);
		
		for(int i = 0; i < k+1; i++) {
			dp[i] = 10001;
		}
		
		dp[0] = 0;
		
		getCoin();
		
		if(dp[k] == 10001) {
			dp[k] = -1;
		}
		
		System.out.println(dp[k]);
	}
	
	static void getCoin() {
		for(int i = 0; i < n; i++) { // 각 동전 가지고 만들 수 있는 개수 배열 
			int w = coin.get(i);
			for(int j = w; j < k+1; j++) {
				dp[j] = Math.min(dp[j - w] + 1, dp[j]);
			}
		}
	}
}