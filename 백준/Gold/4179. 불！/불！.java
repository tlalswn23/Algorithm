
import java.util.*;
import java.io.*;

public class Main {
	static int R, C, count;
	static boolean isEscape;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; 
	static char[][] map;
	static Queue<int[]> fireQ, jihunQ;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		fireQ = new LinkedList<>();
		jihunQ = new LinkedList<>();
		map = new char[R][C];
		
		// 맵 초기화 
		for(int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = c[j];
				
				if(c[j] == 'F') {
					fireQ.add(new int[] {i, j, 0});
				}
				
				if(c[j] == 'J') {
					jihunQ.add(new int [] {i, j, 0});
				}
			}
		}
		
		maze();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(isEscape) {
			bw.write(String.valueOf(count));
		}else {
			bw.write("IMPOSSIBLE");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void maze() {
		
		// 1. 불 퍼지기 
		while(!jihunQ.isEmpty()) {
			
			int size = fireQ.size();
			for(int i = 0; i < size; i++) {
				int[] current = fireQ.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
						continue;
					}
					
					if(map[nx][ny] == '#' || map[nx][ny] == 'F') {
						continue;
					}
					
					map[nx][ny] = 'F';
					fireQ.add(new int[] {nx, ny, current[2]+1});
				}
			}
			
			
			// 2. 지훈 이동 
			size = jihunQ.size();
			for(int i = 0; i < size; i++) {
				int[] current = jihunQ.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
						isEscape = true;
						count = current[2]+1;
						return;
					}
					
					if(map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] =='J') {
						continue;
					}
					
					map[nx][ny] = 'J';
					jihunQ.add(new int[] {nx, ny, current[2]+1});
				}
			}
		}
	}
}