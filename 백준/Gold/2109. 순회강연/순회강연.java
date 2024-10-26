import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] == o1[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
		boolean[] visited = new boolean[10001]; // 해당 날짜에 강연하는지 확인 
		
		for(int i = 0 ; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			queue.add(new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
		}
		
		int total = 0;
		
		// 날짜 빠른 거부터 
		while(!queue.isEmpty()) {
			
			int[] university = queue.poll();
			boolean check = false;
			int day = university[1];
			
			while(day > 0) { // 남는 날짜에 강연 진행
				if(visited[day]) {
					day--;
					continue;
				}
				
				visited[day] = true;
				check = true;
				break;
			}
			
			if(check) { // 해당 강연을 진행할 수 있으면 강연료 추가
				total += university[0];
			}
		}
		
		bw.write(Integer.toString(total));
		bw.close();
		br.close();

	}

}