import java.util.*;
import java.io.*;

public class Main {
	static int N, min;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<int[]> island, edge;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		island = new LinkedList<>();
		visited = new boolean[N][N];
		edge = new LinkedList<>();
			
		// map 입력 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 섬인 칸은 전체 섬을 다른 숫자로 표시하기
		// 2. 표시하면서 그 섬의 가장자리를 큐에 넣기 
		// 3. 큐에서 하나씩 빼면서 bfs 돌리기 해당 칸 방문표시 
		// 3. for문을 돌다가 방문하지 않았고 1인 칸을 만나면 반복 
		
		int number = 2;
		// 전체 확인	
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) {
					continue;
				}
				
				if(map[i][j] != 1) {
					continue;
				}
				
				if(map[i][j] == 1) {
					// 섬을 다른 숫자로 표시하기
					paintMap(i, j, number);
					//printMap();
					
					while(!edge.isEmpty()) {
						int[] current = edge.poll();
						bfs(current[0], current[1], number);
						visited[current[0]][current[1]] = true;
					}
					number++;
				}
			}
		}
		
		System.out.println(min);
	}
	
	static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void paintMap(int x, int y, int number) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		visited[x][y] = true;
		island.add(new int[] {x, y});
		map[x][y] = number;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if(visit[nx][ny]) {
					continue;
				}
				
				if(map[nx][ny] == 0) {
					edge.add(new int[] {nx, ny});
					continue;
				}
				
				visit[nx][ny] = true;
				visited[nx][ny] = true;
				map[nx][ny] = number;
				q.add(new int[] {nx, ny});
				island.add(new int[] {nx, ny});
			}
		}
	}
	
	// 1을 만날 때까지 반복 
	static void bfs(int x, int y, int number) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		int count = 1;
		//System.out.println("시작점 "+x+" "+y);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] current = q.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}
					
					if(visit[nx][ny]) {
						continue;
					}
					
					if(map[nx][ny] != 0 && map[nx][ny] != number) {
						//System.out.println(nx+" "+ny+" "+count);
						min = Math.min(min, count);
						return;
					}
					
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
			count++;
		}
	}
}
