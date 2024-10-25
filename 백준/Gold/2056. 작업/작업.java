
import java.util.*;
import java.io.*;

public class Main{
	static int N, answer;
	static Queue<Integer> queue;
	static List<Integer>[] works;
	static int[] result; // 끝나는 시간 저장하는 배열 
	static int[] time, indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		queue = new LinkedList<>();
		
		N = Integer.parseInt(br.readLine());
		works = new ArrayList[N+1];
		result = new int[N+1];
		time = new int[N+1];
		indegree = new int[N+1];
		
		for(int n = 0; n < N; n++) {
			works[n+1] = new ArrayList<>();
			String[] temp = br.readLine().split(" ");
			int cnt = Integer.parseInt(temp[1]);
			
			time[n+1] = Integer.parseInt(temp[0]); // 시간 저장 
			indegree[n+1] = cnt;
			
			if(cnt == 0) { // 선행 작업이 없는 것은 큐에 저장
				queue.add(n+1);
				result[n+1] = time[n+1];
				continue;
			}
			
			for(int i = 2; i < cnt+2; i++) {
				// 해당 번호에 내 번호를 저장
				works[Integer.parseInt(temp[i])].add(n+1); // 번호는 0부터
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			List<Integer> list = works[current];
			
			for(int j = 0; j < list.size(); j++) {
				int next = list.get(j);
				indegree[next]--;
				
				result[next] = Math.max(result[next], result[current]+time[next]);
				
				if(indegree[next] == 0) {
					queue.add(next);					
				}
			}
		}
		
		for(int i = 1; i < N+1; i++) {
			answer = Math.max(answer, result[i]);
		}
		
		bw.write(Integer.toString(answer));
		bw.close();
	}
}


// 작업 시간, 선행 작업 수, 선행 작업 번호들