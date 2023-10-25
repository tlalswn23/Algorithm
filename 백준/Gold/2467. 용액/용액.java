import java.util.*;
import java.io.*;

public class Main {
	static int N, min;
	static int[] arr, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		answer = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			findSolution(i);
		}
		
		System.out.println(answer[0]+" "+answer[1]);
	}
	
	static void findSolution(int i) {

		int left = i+1; 
		int right = arr.length-1;
		int mid = 0;
		
		while(left <= right) {
			mid = (right+left)/2;
			//System.out.println(arr[i]+" "+arr[mid]);
			int sum = arr[i] + arr[mid];
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				answer[0] = arr[i];
				answer[1] = arr[mid];
			}
			
			if(sum > 0) {
				right = mid-1;
				continue;
			}
			
			if(sum <= 0) {
				left = mid+1;
				continue;
			}
		}
	}
}
