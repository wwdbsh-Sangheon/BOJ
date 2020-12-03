import java.io.*;
import java.util.*;

public class Main
{
	private static int[] T, P;
	private static int n;

	public static void main(String[] args) throws IOException
	{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		T = new int[n+1];
		P = new int[n+1];
		for(int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(1, 0));
		br.close();
	}

	private static int solve(int d, int p)
	{
		int max = 0;

		if(d == n + 1) return p;
		if(d + 1 <= n + 1) max = Math.max(max, solve(d+1, p));
		if(d + T[d] <= n + 1) max = Math.max(max, solve(d+T[d], p+P[d]));

		return max;
	}
}