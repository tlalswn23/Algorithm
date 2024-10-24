
import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, Integer> graph;
	static Map<Integer, Integer> visited;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		int[] sorted = new int[size];
		String[] arr = br.readLine().split(" ");
		int[] origin = new int[size];
		graph = new HashMap<>();
		visited = new HashMap<>();
		
		// 숫자 배열로 저장 
		for(int i = 0; i < size; i++) {
			sorted[i] = Integer.parseInt(arr[i]);
			visited.put(sorted[i], 0);
			origin[i] = sorted[i];
		}
		
		Arrays.sort(sorted); // 정렬 
		
		// 정답 자리와 현재 자리 그래프로 연결
		for(int i = 0; i < size; i++) {
			graph.put(origin[i], sorted[i]);
		}
		
		// 사이클 찾기
		for(int i = 0; i < size; i++) {
			if(visited.get(origin[i]) == 1) {
				continue;
			}
			
			visited.put(origin[i], 1);
			findCycle(origin[i], origin[i], 1);
		}
		
		bw.write(Integer.toString(count));
		bw.close();
	}
	
	static void findCycle(int v, int start, int cnt) {
		
		int next = graph.get(v);
		
		if(next == start) { // 자기 자신을 만나면 끝
			count += (cnt-1);
			return;
		}
		
		if(visited.get(next) == 0) {
			visited.put(next, 1);
			findCycle(graph.get(v), start, cnt+1);
		}
		
	}
}

// 순열 그래프의 사이클의 크기가 최소 연산 횟수 
