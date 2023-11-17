import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] num;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		dp = new long[N][21];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][num[0]] = 1;
		for(int i = 1; i < N-1; i++) { // 두 번째부터 마지막 답을 제외하고 
			for(int j = 0; j < 21; j++) { // 0 ~ 20의 숫자만 확인 
				if(j-num[i] >= 0) {
					dp[i][j] += dp[i-1][j-num[i]];
				}
				if(j+num[i] <= 20) {
					dp[i][j] += dp[i-1][j+num[i]];
				}
			}
		}
		
		System.out.println(dp[N-2][num[N-1]]);
	}
}
