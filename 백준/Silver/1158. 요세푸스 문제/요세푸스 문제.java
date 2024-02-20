import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int K = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int[] result = new int[K];
		int n = 0;
		
		Queue<Integer> numList = new LinkedList<>();
		
		// 큐에 넣기 
		for(int i = 1; i <= K; i++) {
			numList.add(i);
		}
		
		int count = 1;
		int num = 0;
		
		while(!numList.isEmpty()) {
			
			if(count % N != 0) {
				num = numList.poll();
				numList.add(num);
			}
			else {
				num = numList.poll();
				//System.out.print(num+" ");
				result[n] = num;
				n++;
			}
			count++;
		}
		
		System.out.print("<");
		for(int i = 0; i <= n; i++) {
			if(i == n-1) {
				System.out.println(result[i]+">");
				break;
			}
			System.out.print(result[i]+", ");
		}
	}
}
