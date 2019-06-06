import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer div = new StringTokenizer(br.readLine(), "-"); // - 기준 나누기.
		StringTokenizer part = new StringTokenizer(div.nextToken(), "+"); // - 기준 나눈 것을 + 기준 나누기.

		int ans = 0;

		while(part.hasMoreTokens()){
			// 첫 번째 파트.
			ans += Integer.parseInt(part.nextToken());
		}

		// 나머지 전부 빼주기.
		while(div.hasMoreTokens()){
			part = new StringTokenizer(div.nextToken(), "+");
			while(part.hasMoreTokens()){
				ans -= Integer.parseInt(part.nextToken());
			}
		}
		System.out.println(ans);
		br.close();
	}
}