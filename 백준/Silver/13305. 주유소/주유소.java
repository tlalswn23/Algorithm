
import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	static int N;
	static BigDecimal min, total;
	static BigDecimal[] d, w; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		d = new BigDecimal[N-1];
		w = new BigDecimal[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			d[i] = new BigDecimal(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			w[i] = new BigDecimal(st.nextToken());
		}
		
		
		min = new BigDecimal("1000000000"); // 초기화 
		total = BigDecimal.ZERO;
		for(int i = 0; i < N-1; i++) {
			
			if(min.compareTo(w[i]) >= 0) { // min 값과 같거나 작으면 min 값을 갱신
				min = w[i];
			}
			
			total = total.add(d[i].multiply(min));
		}
		
		System.out.println(total);
	}

}