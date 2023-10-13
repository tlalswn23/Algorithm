import java.util.*;

import java.io.*;

public class Main {
	static int N, M, min;
	static List<int[]> cctvs;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	
	// 각  cctv가 확인할 수 있는 방향 
	static int[][] one = {{0}, {1}, {2}, {3}};
	static int[][] two = {{1, 3}, {0, 2}};
	static int[][] three = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
	static int[][] four = {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}};
	static int[][] five = {{0, 1, 2, 3}};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new ArrayList<>();
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					cctvs.add(new int[] {i, j, map[i][j]});
				}
			}
		}
		
		findSafeZone(0, 0, map);
		
		System.out.println(min);
	}
	
	static void findSafeZone(int index, int cnt, int[][] temp) {
		
		if(cnt == cctvs.size()) { // cctv 다 확인했으면 
			int count = getCount(temp);
			min = Math.min(min, count); // 안전지대 최소값 갱신 
			return;
		}
		
		for(int i = index; i < cctvs.size(); i++) {
			int[] cctv = cctvs.get(i);
			int[][] type = getCCTV(cctv[2]);
			int[][] copy = new int[N][M];
			copyMap(copy, map);
			
			// 각 cctv가 확인할 수 있는 방향 리스트 
			for(int n = 0; n < type.length; n++) {
				
				for(int j = 0; j < type[n].length; j++) {
					int nx = cctv[0] + dx[type[n][j]];
					int ny = cctv[1] + dy[type[n][j]];
					
					// 맵을 벗어나지 않을 때까지 직진
					while(nx >= 0 && nx < N && ny >= 0 && ny < M) {
						
						if(temp[nx][ny] == 6) { // 벽이 있으면 멈춤 
							break;
						}
						
						if(temp[nx][ny] > 0 && temp[nx][ny] < 6) { // cctv 있는 곳은 그냥 통과
							nx += dx[type[n][j]];
							ny += dy[type[n][j]];
							continue;
						}
						
						temp[nx][ny] = 9; // 감시되는 곳은 9로 표시 
						nx += dx[type[n][j]];
						ny += dy[type[n][j]];
					}
				}
				// 표시 해줬으면 다음  cctv로 넘어가기 
				findSafeZone(i+1, cnt+1, temp);
				copyMap(temp, copy);
			}
		}
	}
	
	static void printMap(int[][] map) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	static int getCount(int[][] map) {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	static void copyMap(int[][] arr1, int[][] arr2) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr1[i][j] = arr2[i][j];
			}
		}
	}
	
	static int[][] getCCTV(int n) {
		if(n == 1) {
			return one;
		}
		
		if(n == 2) {
			return two;	
		}
		
		if(n == 3) {
			return three;
		}
		
		if(n == 4) {
			return four;
		}
		
		if(n == 5) {
			return five;
		}
		
		return null;
	}
}
