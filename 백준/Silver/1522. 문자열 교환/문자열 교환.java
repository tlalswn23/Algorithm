
import java.io.*;


public class Main {
	static char[] str;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		
		int a = 0; // a의 개수 
		int b = 0;
		// 앞에서부터 b가 나오는 Index 찾기 
		for(int i = 0; i < str.length; i++) {
			if(str[i] == 'a') {
				a++;
			}
		}
		
		for(int i = 0; i < a; i++) {
			if(str[i] == 'b') {
				b++;
			}
		}
		
		int left = 0, right = a-1;
		int min = str.length-1;
		
		while(left < str.length) {
			
			min = Math.min(min, b);
			left++;
			right++;
			
			if(right == str.length) {
				right = 0;
			}
			
			if(str[left-1] == 'b') {
				b--;
			}
			
			if(str[right] == 'b') {
				b++;
			}
		}
		
		System.out.println(min);
	}
}
