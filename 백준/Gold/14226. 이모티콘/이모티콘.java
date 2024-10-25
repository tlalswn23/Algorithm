
import java.util.*;
import java.io.*;

public class Main {
	static int S, cnt;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		S = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 1});
		visited[0][1] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int[] current = queue.poll();
				
				// 1. 클립보드에 현재 이모티콘 복사
				if(!visited[current[1]][current[1]]) {
					visited[current[1]][current[1]] = true;					
					queue.add(new int[] {current[1], current[1]});	
				}
				
				// 2. 클립보드에 있는 거 붙여넣기
				int[] next2 = new int[] {current[0], current[1]+current[0]};
				if(next2[1] < S && !visited[next2[0]][next2[1]]) {
					visited[next2[0]][next2[1]] = true;
					queue.add(next2);					
				}

				// 3. 하나 삭제하기 
				int[] next3 = new int[] {current[0], current[1]-1};
				if(next3[1] < S && next3[1] > 0 && !visited[next3[0]][next3[1]]) {
					visited[next3[0]][next3[1]] = true;
					queue.add(next3);		
				}
				
				if(next2[1] == S || next3[1] == S) {
					bw.write(Integer.toString(cnt+1));
					bw.close();
					return ;
				}
			}
			cnt++;
		}
		
		bw.close();
	}
}
