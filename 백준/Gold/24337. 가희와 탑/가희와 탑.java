import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int a = Integer.parseInt(str[1]);
		int b = Integer.parseInt(str[2]);
		int[] answer = new int[N];
		
		int cnt = N-b-a; // 1로 채울 자리 수
		
		if(cnt < -1) { // 조건 만족 X
			bw.write(Integer.toString(-1));
			bw.close();
			return;
		}
		
		int max = 0;
		// 뒤에서부터 b만큼 건물 채우기
		for(int i = 1; i <= b; i++) {
			answer[N-i] = i;
			max = i;
		}
		
		if(a == 1) { // a가 1 일때만 따로 처리
			answer[0] = max;
			
			for(int i = 1; i < N-b; i++) { // 나머지는 1로 채우기
				answer[i] = 1;
			}
			
			if(N != b) {
				answer[N-b] = 1;				
			}
			
		}else { // a가 2이상이면
			for(int i = 1; i < a-1; i++) { // a-1개만큼 계단식으로 채우기
				answer[N-b-i] = max-i;
			}
			
			answer[N-b] = Math.max(answer[N-b], a); // 더 큰 수를 꼭대기에 세워주기 
			
			int value = a-1;
			for(int i = N-b-1; i > N-b-a; i--) { // a-1만큼 계단식으로 채우기
				answer[i] = value;
				value--;
			}
			
			// 나머지 부분은 1로 채우기
			int index = 0;
			while(answer[index] == 0) {
				answer[index] = 1;
				index++;
			}
		}

		// 출력
		for(int i = 0; i < N; i++) {
			bw.write(Integer.toString(answer[i])+" ");
		}
		bw.close();
	}
}
