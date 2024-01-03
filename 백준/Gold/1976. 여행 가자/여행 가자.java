
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static String answer;
	static int[] route, parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		answer = "YES";
		parent = new int[N+1];
		
		// 부모 배열 초기화 
		for(int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(i+1, j+1);
				}
			}
		}
		
		String[] str = br.readLine().split(" ");
		for(int i = 1; i < M; i++) {
			int current = Integer.parseInt(str[i]);
			
			if(!equals(Integer.parseInt(str[0]), current)) {
				answer = "NO";
			}
		}
		
		System.out.println(answer);
		
	}

	// 부모 저장 
	static void union(int i, int j) {
		int x = find(i);
		int y = find(j);
		
		if(x < y) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
		}
	}
	
	// 부모 노드 찾기 
	static int find(int i) {
		if(parent[i] == i) {
			return i;
		}
		
		return parent[i] = find(parent[i]);
	}
	
	// 같은 부모를 가졌는지 확인 
	static boolean equals(int i, int j) {
		return find(i) == find(j);
	}
}
