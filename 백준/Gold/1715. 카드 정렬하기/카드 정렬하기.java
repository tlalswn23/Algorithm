
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			queue.add(num);
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int total = 0;
		
		while(queue.size() > 1) {
			int n1 = queue.poll();
			int n2 = queue.poll();
			int sum = n1+n2;
			total += sum;
			
			queue.add(sum);
		}
		
		System.out.println(total);
		
	}

}
