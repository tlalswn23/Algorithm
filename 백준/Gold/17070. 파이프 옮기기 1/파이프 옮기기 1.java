import java.io.*;

public class Main {
	
	static int[][] matrix;
	static int N, count;
	// 파이프 끝이 갈 수 있는 방향 -->  오른쪽 대각선아래, 오른쪽, 아래
	static int[] dx = {1, 0, 1}; 
	static int[] dy = {1, 1, 0};
	//static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];

		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		movePipe(0, 1, 1); // 0, 1에서 시작하고 오른쪽으로 누워있기 때문에 
		
		System.out.println(count);
	}
	
	
	//status -  현재 파이프가 어떤 방향인지 상태 체크 : 0 - 대각선 / 1 - 오른쪽  / 2 - 아래
	public static void movePipe(int x, int y, int state) {
		
		if(x == N-1 && y == N-1) { // N, N 좌표에 도착 
			count++;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			
			if(state == 1 && i == 2) { // 오른쪽일 때 아래로 못감 
				continue;
			}else if(state == 2 && i == 1) { // 아래일 때 오른쪽으로 못감 
				continue;
			}
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 좌표가 매트릭스를 벗어나면 
			if(nx < 0 || nx >= N ||  ny < 0 || ny >= N)
				continue;
			
			if(matrix[nx][ny] == 1) { // 벽이 아니면 
				continue;
			}
			
			if(i == 0) {
				if(matrix[x][y+1] == 1 || matrix[x+1][y] == 1) {
					continue;
				}
			}
			
			movePipe(nx, ny, i);
		}
		
		return;
	}
}
