
import java.util.*;
import java.io.*;


//우선순위 큐 
public class Main {

	
	static List<Lecture> llist;
	static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] str = new String[2];
		int cnt;
		
		llist = new ArrayList<Lecture>();

		for(int i = 0; i < N; i++) {
			str = bf.readLine().split(" ");
			llist.add(new Lecture(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		
		// 강의실을 최소로 쓰도록 
		// 강의시간이 겹치지 않는 강의를 최대한 많이 뽑는 것 
		// 강의 시작시간이 빠른 순으로 정렬 
		Collections.sort(llist);
		
		cnt = classroom(N);
		
		System.out.println(cnt);
        
        bf.close();
		
	}
	
	public static int classroom(int N) {
		queue.offer(llist.get(0).getEnd());
		
		for(int i = 1; i < N; i++) {
			if(llist.get(i).getStart() >= queue.peek())
				queue.poll();
			
			queue.offer(llist.get(i).getEnd());
		}
		return queue.size();
	}
	
	
	public static class Lecture implements Comparable<Lecture>{
		int start;
		int end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		

		public int getStart() {
			return start;
		}



		public void setStart(int start) {
			this.start = start;
		}



		public int getEnd() {
			return end;
		}



		public void setEnd(int end) {
			this.end = end;
		}

		// 시작 시간이 같으면 종료 시간이 더 빠른 것으로 정렬 
		@Override
		public int compareTo(Lecture o) {
			// TODO Auto-generated method stub
			
			if(start == o.start)
				return end - o.end;
			
			return start - o.start;
		}
	}
}
