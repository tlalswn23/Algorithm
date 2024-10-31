import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<Integer> numbers = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		
		
		// 0과 음수 처리 
		while(!numbers.isEmpty() && numbers.peek() <= 0) {
			int n1 = numbers.poll();
			
			if(numbers.isEmpty() || numbers.peek() > 0) {
				answer += n1;
				break;
			}
			
			int n2 = numbers.poll();
			
			answer += (n1*n2);
		}
		
		PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
		positive.addAll(numbers);
		
		// 양수 처리
		while(!positive.isEmpty()) {
			
			int n1 = positive.poll();
			
			if(positive.isEmpty() || positive.peek() == 1) { // 양수가 홀수개일 때는 마지막 양수는 그냥 더해주기
				answer += n1;
				break;
			}
	
			int n2 = positive.poll();
			
			
			answer += (n1*n2);
		}
		
		// 남은 1처리
		answer += positive.size();
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();
	}
}
