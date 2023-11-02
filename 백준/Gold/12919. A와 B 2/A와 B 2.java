
import java.io.*;

public class Main {
	static String S, T;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		findString(T);
		
		System.out.println(result);
	}
	
	static void findString(String str) {
		int last = str.length();

		if(S.length() == str.length()) {
			if(S.equals(str)) {
				result = 1;
			}			
			return;
		}
		
		if(str.charAt(last-1) == 'A') {
			findString(str.substring(0, last-1));
		}
		
		if(str.charAt(0) == 'B'){
			StringBuffer sb = new StringBuffer(str);
			String temp = sb.reverse().toString();
			findString(temp.substring(0, last-1));
		}
	}
}
