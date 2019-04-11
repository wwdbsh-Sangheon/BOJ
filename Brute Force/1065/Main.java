import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int ans = 0;

		for(int i = 1; i <= n; i++) // 주어진 정수 보다 작거나 같은 값들 검사
		{
			if(i < 100) // 100 보다 작으면 경우에 상관없이 한수.
			{
				ans++;
				continue;
			}
			if(hansu(String.valueOf(i))) ans++; // 3자릿수 부터 hansu 메소스로 검사. 사실상 3자릿수라고 정해져있음.
		}
		System.out.println(ans);
		br.close();
	}

	private static boolean hansu(String num) // 문제 맞춤 메소드.
	{
		int d1 = (int)num.charAt(1) - (int)num.charAt(0);
		int d2 = (int)num.charAt(2) - (int)num.charAt(1);

		return (d1 == d2) ? true : false;
	}

	// private static boolean hansu(String num)
	// {
	// 	int d = (int)num.charAt(1) - (int)num.charAt(0); // 공차

	// 	for(int i = 2; i < num.length(); i++)
	// 	{
	// 		// 한자릿수 옮겨가며 공차와 같은지 다른지 검사. 사실상 3자릿수라고 정해져있기 때문에 루프 필요없음.
	// 		if(d != (int)num.charAt(i) - (int)num.charAt(i-1))
	// 		{
	// 			return false;
	// 		}
	// 	}

	// 	return true;
	// }
}