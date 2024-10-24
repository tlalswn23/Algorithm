
import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static List<Integer>[] graph;
	static boolean check;
	static int[] colorArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		for(int k = 0; k < K; k++) {
			String[] temp = br.readLine().split(" ");
			V = Integer.parseInt(temp[0]);
			E = Integer.parseInt(temp[1]);
			graph = new ArrayList[V+1];
			colorArr = new int[V+1];
			
			// 그래프 초기화
			for(int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// 그래프 연결
			for(int i = 0; i < E; i++) {
				String[] info = br.readLine().split(" ");
				int v1 = Integer.parseInt(info[0]);
				int v2 = Integer.parseInt(info[1]);
				
				 // 양방향 그래프
				graph[v1].add(v2);
				graph[v2].add(v1);
			}
			
			check = false;

			// 홀수 사이클 있는지 확인
			for(int i = 1; i <= V; i++) {

				if(colorArr[i] > 0) {
					continue;
				}

				colorArr[i] = 1;
				rescCycle(i, 1);
				
				if(check) { // 홀수 사이클이 있으면
					bw.write("NO\n");
					break;
				}
			}
			
			if(!check) {
				bw.write("YES\n");
			}
		}
		bw.close();
	}
	
	
	// 재귀로 사이클 찾기 : 내 다음 정점이 나랑 같은 색이면 안됨
	// 색깔은 1 아니면 2
	static void rescCycle(int v, int color) {
		
		for(int i = 0; i < graph[v].size(); i++) {
			if(check) {
				return;
			}
			
			int next = graph[v].get(i);
			
			if(colorArr[next] == colorArr[v]) { // 다음 정점이 나랑 같은 색이면 안됨
				check = true;
				return;
			}
			
			if(colorArr[next] > 0) {
				continue;
			}
			
			colorArr[next] = 3 - color;
			rescCycle(next, 3 - color);
		}
	}

}
