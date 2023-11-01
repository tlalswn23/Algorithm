
import java.util.*;
import java.io.*;

public class Main {
	static class Meeting{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		List<Meeting> meetings = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetings.add(new Meeting(start, end));
		}
		
		// 시작 시간순으로 정렬 
		Collections.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
		
		
		for(int i = 0; i < N; i++) {
			Meeting current = meetings.get(i);
			
			if(queue.isEmpty()) {
				queue.add(current.end);
				continue;
			}
			
			int time = queue.poll();
			if(current.start < time) {
				queue.add(time);
			}
			
			queue.add(current.end);
			
		}
		
		System.out.println(queue.size());
	}
}
