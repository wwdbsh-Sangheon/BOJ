/*
완전탐색 문제. 입력값이 오름차순으로 정렬되어 있어 출력시 사전순 고려할 필요없음.
리스트와 시작값을 함수에 재귀적으로 넘겨주어 모든 부분을 탐색.
*/
import java.io.*;
import java.util.*;

public class Main
{
	private static int[] number;
	private static int k;

	public static void main(String[] args) throws IOException
	{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true)
		{
			String line = br.readLine();
			if(line.equals("0")) break;
			st = new StringTokenizer(line);
			k = Integer.parseInt(st.nextToken());
			number = new int[k];
			for(int i = 0; i < k; i++) number[i] = Integer.parseInt(st.nextToken());
			LinkedList<Integer> ret = new LinkedList<Integer>();
			solve(ret, 0);
			System.out.println();
		}
		br.close();
	}

	private static void solve(LinkedList<Integer> ret, int start)
	{
		if(ret.size() == 6)
		{
			for(int i : ret)
			{
				System.out.print(i + " ");
			}
			System.out.println();

			return ;
		}

		for(int i = start; i < number.length; i++)
		{
			ret.add(number[i]);
			solve(ret, i+1);
			ret.removeLast();
		}
	}
}