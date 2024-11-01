import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N, M, count;
	static boolean[][] visited;
	static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Queue<int[]> cheese;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		visited = new boolean[N+2][M+2]; // 테두리 남겨두기 위해 +2
		cheese = new LinkedList<>();
		map = new int[N+2][M+2];
		
		// 맵 세팅
		for(int i = 1; i <= N; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		
		int time = 0;
		
		while(checkCheese()) { // 치즈가 남아있다면 반복 
			// 1. 바깥에서부터 BFS로 치즈겉면 찾기(치즈 수 카운트)
			findCheese();
			count = cheese.size();
			
			// 2. 치즈 겉면 0으로 바꾸기
			meltCheese();
			
			// 3. 반복
			time++;
		}
		
		
		bw.write(Integer.toString(time)+"\n");
		bw.write(Integer.toString(count)+"\n");
		
		bw.close();
		br.close();
		
	}
	
	static void findCheese() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		boolean[][] visit = new boolean[N+2][M+2];
		visit[0][0] = true;
		
		// 빈칸을 탐색하되 치즈 겉면을 만나면 큐에 넣기 
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = pos[0] + direction[d][0];
				int ny = pos[1] + direction[d][1];
				
				if(nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2) {
					continue;
				}
				
				if(visit[nx][ny]) {
					continue;
				}
				
				if(map[nx][ny] == 1) {
					visit[nx][ny] = true;
					cheese.add(new int[] {nx, ny});
					continue;
				}
				
				visit[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}
	}
	
	// 치즈 녹이기
	static void meltCheese() {
		while(!cheese.isEmpty()) {
			int[] pos = cheese.poll();
			map[pos[0]][pos[1]] = 0;
		}
	}

	static boolean checkCheese() {
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}
}