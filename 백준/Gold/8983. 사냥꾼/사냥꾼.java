import java.util.*;
import java.io.*;

public class Main {
	static int M, N, L;
	static int[] box;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = 0;
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		L = Integer.parseInt(input[2]);
		
		box = new int[M];
		String[] xInput = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(xInput[i]);
		}
		
		Arrays.sort(box); // 사대 거리순으로 정렬

		// 동물 위치 리스트에 등록
		for(int i = 0; i < N; i++) {
			String[] pos = br.readLine().split(" ");
			int x = Integer.parseInt(pos[0]);
			int y = Integer.parseInt(pos[1]);
			
			// 이분탐색으로 가장 가까운 사대 찾기
			int left = 0;
			int right = M-1;
			int mid = 0;
			
			while(left <= right) {
				mid = (right+left)/2;
				
				// 해당 사대에서 동물을 잡을 수 있는지 확인
				if((Math.abs(box[mid]-x) + y) <= L) {
					answer++;
					break;
				}
				
				if(box[mid] == x) { // 가장 가까울 때
					break;
				}
				
				if(box[mid] > x) { // 박스가 오른쪽에 있으면 작게 해야함 
					right = mid - 1;
					continue;
				}
				
				if(box[mid] < x) {
					left = mid + 1;
				}
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.close();
		br.close();
	}

}

// 각 동물마다 가장 가까운 사대를 찾고, 해당 사대에서 동물을 잡을 수 있는지 확인해서 count 
