
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
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		stack.add(N);
		for(int i = N-1; i > 0; i--) {
			
			while(!stack.isEmpty() && tower[i] >= tower[stack.peek()]) {
				result[stack.pop()] = i;
			}
			
			stack.add(i);
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = 0;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(result[i]+" ");
		}
	}

}
