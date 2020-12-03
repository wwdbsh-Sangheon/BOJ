import java.io.*;
import java.util.*;

public class Main{

	private static int[] p;
	private static int n;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		p = new int[n];
		for(int i = 0; i < n; i++){
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p); // 시간의 합을 최솟값으로 만들어주기 위해 오름차순 정렬.

		int ans = 0;

		for(int i = n; i > 0; i--){
			ans += p[n-i]*i;
		}
		System.out.println(ans);
		br.close();
	}
}