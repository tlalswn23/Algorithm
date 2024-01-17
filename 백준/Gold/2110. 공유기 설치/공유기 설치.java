import java.util.*;
import java.io.*;

public class Main {
	static int N, C, answer;
	static int[] house;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		// Upper Bound 
		int lo = 1, hi = house[N-1] - house[0] + 1;
		
		while(lo < hi) { 
			int mid = (lo+hi)/2;
			
			if(getDistance(mid) < C) {  // 개수에 못미치면 거리를 좁혀야 함 
				hi = mid;
			}
			else { // 개수가 일치하거나 더 많으면 거리를 늘려도 됨(최대 거리를 찾아야되기 때문)
				lo = mid + 1;
			}
		}
		
		System.out.println(lo-1); // 초과하는 첫 번째 값이므로 -1 
	}
	
	
	// 해당 최소 거리 기준으로 설치할 수 있는 공유기 수 
	static int getDistance(int d) {
		int cnt = 1;
		int h = house[0];
		
		for(int i = 1; i < N; i++) {
			if((house[i] - h) < d) {
				continue;
			}
			
			cnt++;
			h = house[i];
		}
		
		return cnt;
	}
}
