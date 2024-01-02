
import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	static int N;
	static PriorityQueue<BigDecimal> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<BigDecimal>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			String num = "";
			
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				// 현재 문자가 숫자이면 num에 추가 
				// 현재 문자가 숫자가 아니면 num이 있으면 큐에 추가 
				if(47 <= c && c <= 57) {
					num += c;
				}else {
					if(!num.equals("")) {
						queue.add(new BigDecimal(num));
						num = "";
					}
				}
			}
			
			if(!num.equals("")) {
				queue.add(new BigDecimal(num));
			}
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
