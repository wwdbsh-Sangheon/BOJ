import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int ans = 987654321, len_diff = b.length() - a.length();
		// 두 문자열 길이의 차이+1번 문자열 비교 수행.
		for(int i = 0; i <= len_diff; i++){
			int diff = 0;
			for(int j = 0; j < a.length(); j++){
				if(a.charAt(j) != b.charAt(j+i)){
					diff++;
				}
			}
			ans = Math.min(ans, diff);
		}
		System.out.println(ans);
		br.close();
	}
}