
import java.util.*;
import java.io.*;

public class Main {
	static int N, count1, count2;
	static char[][] map;
	static boolean[][] visited, visited2;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 적록색약 아닌 사람 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					count1++;
				}
				
				if(!visited2[i][j]) {
					bfs2(i, j);
					count2++;
				}
			}
		}
		
		System.out.println(count1+" "+count2);

	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				if(map[nx][ny] == map[x][y]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	static void bfs2(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if(visited2[nx][ny]) {
					continue;
				}
				if(map[nx][ny] == map[x][y]) {
					visited2[nx][ny] = true;
					queue.add(new int[] {nx, ny});
					continue;
				}
				
				if(map[x][y] == 'R' || map[x][y] == 'G') {
					if(map[nx][ny] == 'R' || map[nx][ny] == 'G') {
						visited2[nx][ny] = true;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
