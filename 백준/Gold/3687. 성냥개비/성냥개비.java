
import java.util.*;
import java.io.*;

public class Main {
	static List<int[]> numbers;
	static int N;
	static String max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			min = "";
			max = "";
			N = Integer.parseInt(br.readLine());
			getMaxNumber();
			getMinNumber();
			System.out.println(min+" "+max);
		}
	}
	
	
	static void getMaxNumber() {
		
		if((N%2) == 0) {
			for(int i = 0; i < N/2; i++) {
				max += "1";
			}
			return;
		}
		
		max = "7";
		for(int i = 1; i < N/2; i++) {
			max += "1";
		}
	}
	
	static void getMinNumber() {
		long[] arr = new long[101];
		long[] matches = new long[9];
		
		// arr init
		arr[0] = matches[0] = 0;
		arr[1] = matches[1] = 0;
		arr[2] = matches[2] = 1;
		arr[3] = matches[3] = 7;
		arr[4] = matches[4] = 4;
		arr[5] = matches[5] = 2;
		arr[6] = 6; matches[6] = 0;
		arr[7] = matches[7] = 8;
		arr[8] = matches[8] = 10;
		
		for(int i = 9; i < 101; i++) {
			arr[i] = arr[i-2]*10 + matches[2];
			for(int j = 3; j < 8; j++) {
				arr[i] = Math.min(arr[i], arr[i-j]*10+matches[j]);
			}
		}
		
		min = arr[N]+"";
	}
}
