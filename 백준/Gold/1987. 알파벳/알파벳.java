import java.io.*;
import java.util.Arrays;

public class Main {
	
	static int R, C, max;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] count;
	static char[][] board;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		count = new int[26];
		visited = new boolean[R][C];
		board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		count[toInt(board[0][0])]++; // 처음 말의 위치 
		visited[0][0] = true;
		move(0, 0, 1);
		
		System.out.println(max);
	}
	
	static int toInt(char c) {
		return c - 65;
	}
	
	static void move(int i, int j, int cnt) {
		
		max = Math.max(max, cnt);
		
		for(int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			// 말이 범위를 벗어나면 x
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
				continue;
			}
			
			// 방문하지 않았고 count가 0이면(나온 적 없으면)
			if(!visited[nx][ny] && count[toInt(board[nx][ny])] == 0) {
				visited[nx][ny] = true;
				count[toInt(board[nx][ny])]++;
				move(nx, ny, cnt+1);
				visited[nx][ny] = false;
				count[toInt(board[nx][ny])]--;
			} 
		}
		return;
	}
}
