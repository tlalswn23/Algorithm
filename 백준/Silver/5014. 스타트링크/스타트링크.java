
import java.util.*;

import java.io.*;


public class Main {
	static int F, S, G, U, D;
	static int[] count;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		count = new int[F+1];
		
		if(S == G) {
			System.out.println(0);
			return;
		}
		
		useElevator();
		
		if(count[G] == 0) {
			System.out.println("use the stairs");
		}else {
			System.out.println(count[G]);			
		}

	}

	static void useElevator() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			int up = current+U;
			int down = current-D;
			
			if(up != S && up <= F && count[up] == 0) {
				queue.add(up);
				count[up] = count[current]+1;
			}
			
			if(down != S && down >= 1 && count[down] == 0) {
				queue.add(down);
				count[down] = count[current]+1;
			}
		}
	}
}
