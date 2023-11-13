
import java.util.*;

import java.io.*;

public class Main {
	static int N;
	static int[] tower, result;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		tower = new int[N+1];
		result = new int[N+1];
		stack = new Stack<>();
		
		for(int i = 1; i <= N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(N);
		for(int i = N-1; i > 0; i--) {
			
			while(!stack.isEmpty() && tower[i] >= tower[stack.peek()]) {
				result[stack.pop()] = i;
			}
			
			stack.push(i);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(result[i]+" ");
		}
		
		System.out.println(sb);
	}

}
