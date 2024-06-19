
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int[] rank;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		rank = new int[T];
		list = new ArrayList<>();
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {l, w, i});
		}
		
		Collections.sort(list, (o1, o2) -> o2[0] == o1[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
		
		for(int i = 0; i < T; i++) {
			int[] person = list.get(i);
			int j = i-1;
			
			int count = 0;
			while(j > -1) {
				int[] bigger = list.get(j);
				if(bigger[0] > person[0] && bigger[1] > person[1]) {
					count++;
				}
				j--;
			}
			rank[person[2]] = count;
		}
		
		for(int i = 0; i < T; i++) {
			bw.write(Integer.toString(rank[i]+1)+" ");
		}
		bw.close();
	}
}
