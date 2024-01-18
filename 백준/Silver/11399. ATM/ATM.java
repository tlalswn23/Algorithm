
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] people, cost;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		people = new int[N];
		cost = new int[N];
		
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(people);
		
		cost[0] = people[0];
		int total = cost[0];
		for(int i = 1; i < N; i++) {
			cost[i] = cost[i-1] + people[i];
			total += cost[i];
		}
		
		
		System.out.println(total);
	}

}
