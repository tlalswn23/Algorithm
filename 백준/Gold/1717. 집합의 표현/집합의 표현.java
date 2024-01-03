
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		// 부모 초기화 
		for(int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int calc = Integer.parseInt(st.nextToken()); // 연산 
			int n1 = Integer.parseInt(st.nextToken()); 
			int n2 = Integer.parseInt(st.nextToken());
			
			if(calc == 0) { // union
				union(n1, n2);
			}
			
			if(calc == 1) { // 같은 집합인지 확인 
				String answer = "NO";
				if(find(n1) == find(n2)) {
					answer = "YES";
				}
				System.out.println(answer);
			}
		}
	}
	
	static void union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		
		parent[root1] = root2;
		
	}
	
	static int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		
		return parent[n] = find(parent[n]);
	}

}
