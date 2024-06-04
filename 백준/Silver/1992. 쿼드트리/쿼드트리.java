import java.io.*;

public class Main {
	
	static int[][] matrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		quadTree(0, 0, N);
	}
	
	public static void quadTree(int r, int c, int size) {
		int sum = 0;

		for(int i = r, rEnd = r+size; i < rEnd; i++) {
			for(int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += matrix[i][j];
			}
		}
		
		// 더이상 재귀가 이루어지지 않는 앞의 두 if문이 기저조건이 됨 
		if(sum == size * size) { // 모두 검은색 
			System.out.print(1);
		}else if(sum == 0) { // 모두 하얀색
			System.out.print(0);
		}else { // 혼합된 상황
			// 4분할 
			int half = size/2;
			System.out.print("(");
			quadTree(r, c, half);
			quadTree(r, c+half, half);
			quadTree(r+half, c, half);
			quadTree(r+half, c+half, half);
			System.out.print(")");
		}
	}
}
