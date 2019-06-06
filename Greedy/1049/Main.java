import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] six = new int[m];
		int[] one = new int[m];
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			six[i] = Integer.parseInt(st.nextToken());
			one[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(six);
		Arrays.sort(one);

		int ans = 0;
		int min = Math.min(six[0], one[0]*6); // 패키지와 낱개로 6개를 사는 가격 중 작은 값 추출.

		// n이 6 보다 작아질때 까지 반복. 
		while(n >= 6){
			n -= 6;
			ans += min;
		}
		// 패키지와 낱개로 n개를 사는 가격 중 작은 값 추출.
		min = Math.min(six[0], one[0]*n);
		System.out.println(ans+min);
		br.close();
	}
}