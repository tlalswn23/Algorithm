
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static int N, M, G;
	static int[][] map;
	static Map<Integer, int[]> people; // 각 승객의 도착지 저장할 맵 
	static int[] start;
	static int[] dx = {-1, 0, 0, 1}; // 상 좌 우 하 
	static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		start = new int[2];
		people = new HashMap<>();
		
		// 맵 초기화 
		for(int i = 1; i <= N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st1.nextToken()) == 1) {
					map[i][j] = -1; // 벽은 -1로 표시 
				}
			}
		}
		
		// 택시 출발지 
		st = new StringTokenizer(br.readLine());
		start[0] = Integer.parseInt(st.nextToken());
		start[1] = Integer.parseInt(st.nextToken());
		
		// 승객 초기화 
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			// 맵에 출발지 표시
			map[startX][startY] = i;
			
			// 해시맵에 도착지 추가 
			people.put(i, new int[] {endX, endY});
		}
		
		
		// 로직 수행 
		for(int i = 0; i < M; i++) {
			// 가장 가까운 승객 찾기 
			int[] c = findCloseMan();
			if(c[0] == -1 || !checkGas(c[1])) {
				System.out.println(-1);
				return;
			}
			
			// 도착지까지 데려다주기 
			int cost = goToEnd(c[0]);
			if(cost == -1 || !checkGas(cost)) {
				System.out.println(-1);
				return;
			}
			G += cost*2;
		}
		
		System.out.println(G);
	}
	
	// BFS 가장 가까운 승객 찾기 -> 시작 자표 주기, 거리도 재야 함 
	static int[] findCloseMan() {
		// 0보다 큰 번호를 찾으면 됨 
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][N+1];
		int[] temp = {N+1, N+1};
		int number = 0;
		int cost = 0;
		boolean check = false;
		
		if(map[start[0]][start[1]] > 0) { // 택시와 승객이 같은 위치에 서 있으면 
			int num = map[start[0]][start[1]];
			map[start[0]][start[1]] = 0;
			return new int[] {num, 0};
		}
		
		queue.add(new int[] {start[0], start[1]});
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {				
				int[] current = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					
					if(!checkRange(nx, ny)) {
						continue;
					}
					
					if(map[nx][ny] == -1) {
						continue;
					}
					
					if(visited[nx][ny]) {
						continue;
					}
					
					if(map[nx][ny] > 0) {
						if(temp[0] > nx) {
							if(check) {								
								map[temp[0]][temp[1]] = number;
							}
							number = map[nx][ny];
							temp[0] = nx;
							temp[1] = ny;
							map[nx][ny] = 0;
						}
						else if(temp[0] == nx && temp[1] > ny){
							if(check) {								
								map[temp[0]][temp[1]] = number;
							}
							number = map[nx][ny];
							temp[0] = nx;
							temp[1] = ny;
							map[nx][ny] = 0;
						}
						check = true;
					}
					
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
			cost++;
			if(check) {
				start[0] = temp[0];
				start[1] = temp[1];
				return new int[] {number, cost};
			}
		}
		
		return new int[] {-1, -1};
	}
	
	static boolean checkRange(int nx, int ny) {
		if(nx < 1 || nx >= N+1 || ny < 1 || ny >= N+1) {
			return false;
		}
		
		return true;
	}
	
	static boolean checkGas(int c) {
		G -= c;
		if(G < 0) {
			return false;
		}
		
		return true;
	}
	
	static int goToEnd(int num) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][N+1];
		int cost = 0;
		int[] end = people.get(num);
		
		if(start[0] == end[0] && start[1] == end[1]) {
			return 0;
		}
		
		queue.add(new int[] {start[0], start[1]});
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {				
				int[] current = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					
					if(!checkRange(nx, ny)) {
						continue;
					}
					
					if(map[nx][ny] == -1) {
						continue;
					}
					
					if(visited[nx][ny]) {
						continue;
					}
					
					if(nx == end[0] && ny == end[1]) {
						start[0] = nx;
						start[1] = ny;
						return cost+1;
					}
					
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			cost++;
		}
		
		return -1;
	}

}
