import java.io.*;
import java.util.*;

public class Main
{
	private static int[] array; // 수열을 입력받을 배열
	private static int n, s, ans = 0;

	public static void main(String[] args) throws IOException
	{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		array = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) array[i] = Integer.parseInt(st.nextToken());		
		solve(0, -1, 0);
		System.out.println(ans);
		br.close();
	}

	// sum: 부분수열 원소들의 합, idx: 수열의 색인, count: 사용된 수열의 원소 수
	private static void solve(int sum, int idx, int count)
	{
		// 모든 원소들을 사용하였을때.
		if(idx == n-1)
		{
			// 수열이 공집합이 아니고 합계가 s와 같을시 ans++
			if(count != 0 && sum == s) ans++;

			return; // 메소드 종료.
		}
		solve(sum, idx+1, count); // 다음 원소를 포함하지 않을때.
		solve(sum + array[idx+1], idx+1, count+1); // 다음 원소를 포함할때.
	}
}