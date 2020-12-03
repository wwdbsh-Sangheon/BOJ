import java.io.*;
import java.util.*;

public class Main{

	private static String A, B;
	private static int ans = 50;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();

		// A와 B를 비교 할 수 있는 전체 경우의 수 B.length() - A.length()
		for(int i = 0; i <= B.length() - A.length(); i++){
			int diff = 0;
			// A, B 비교.
			for(int j = 0, k = i; j < A.length(); j++, k++){
				if(A.charAt(j) != B.charAt(k)) diff++;
			}
			ans = Math.min(ans, diff); // 최솟값 도출.
			if(ans == 0) break;
		}
		System.out.println(ans);
		br.close();
	}
}