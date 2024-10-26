
import java.util.*;
import java.io.*;

public class Main{
	static boolean[][] visited;
	static int A, B, C, sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] temp = br.readLine().split(" ");
		A = Integer.parseInt(temp[0]);
		B = Integer.parseInt(temp[1]);
		C = Integer.parseInt(temp[2]);
		sum = A + B + C;
		visited = new boolean[1501][1501];
		
		if(sum % 3 != 0) {
			bw.write(Integer.toString(0));
			bw.close();
			return;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {A, B, C});
		visited[A][B] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int a = tmp[0];
			int b = tmp[1];
			int c = tmp[2];
			
			if(a == b && b == c) {
				bw.write(Integer.toString(1));
				bw.close();
				return;
			}
			
			// 다른 두 그룹 뽑아서 계산 후 방문 확인, 큐에 넣기 
			if(a != b) {
				int na = a > b ? a - b : a + a;
				int nb = a > b ? b + b : b - a;
				
				if(!visited[na][nb]) {
					visited[na][nb] = true;
					queue.add(new int[] {na, nb, c});
				}
			}
			
			if(b != c) {
				int nb = b > c ? b - c : b + b;
				int nc = b > c ? c + c : c - b;
				
				if(!visited[a][nb]) {
					visited[a][nb] = true;
					queue.add(new int[] {a, nb, nc});
				}
			}
			
			if(a != c) {
				int na = a > c ? a - c : a + a;
				int nc = a > c ? c + c : c - a;
				
				if(!visited[na][b]) {
					visited[na][b] = true;
					queue.add(new int[] {na, b, nc});
				}
			}
		}
		
		bw.write(Integer.toString(0));
		bw.close();
	}
}
