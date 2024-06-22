import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] move;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		move = new int[101]; // 0보다 큰 값이면 어디론가 이동함 
		
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			move[from] = to;
		}
		
		System.out.println(playGame());
	}
	
	static int playGame() {
		int cnt = 0;
		int num = 1;
		boolean[] visited = new boolean[101];
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		//visited[num] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int n = 0; n < size; n++) {
				int c = q.poll();
				
				for(int i = 1; i <= 6; i++) {
					int newNum = c + i;
					
					if(newNum == 100) {
						return cnt+1;
					}
					
					if(newNum > 100) {
						continue;
					}
					
					if(move[newNum] != 0) {
						newNum = move[newNum];
					}
					
					if(visited[newNum]) {
						continue;
					}
					
					q.add(newNum);
					visited[newNum] = true;
				}
			}
			cnt++;
		}
		
		return cnt;
	}
}
