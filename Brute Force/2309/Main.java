import java.io.*;
import java.util.*;

public class Main
{
	private static int[] height = new int[9];
	private static boolean flag = false; // 한가지 경우의수 출력후 메소스 종료를 위한 변수.

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) height[i] = Integer.parseInt(br.readLine());
		Arrays.sort(height); // 오름차순 출력을 위한 정렬.
		solve(new LinkedList<Integer>(), 0, 0); // 연결리스트를 인자로 넘겨줌.
		br.close();
	}

	// dwarf: 난쟁이들을 넣어줄 리스트, start: 완전탐색의 중복을 막기위한 변수, sum: 카의 합
	private static void solve(LinkedList<Integer> dwarf, int start, int sum)
	{
		if(sum > 100) return ; // 기저사례1: 키의 합이 100을 넘어가면 종료.
		if(dwarf.size() == 7) // 기저사례2: 연결리스트의 사이즈가 7이면 종료.
		{
			if(sum == 100) // 합이 100이면 리스트 출력.
			{
				for(int i : dwarf) System.out.println(i);
				flag = true;
			}
			return ;
		}

		for(int i = start; i < 9; i++)
		{
			dwarf.add(height[i]); // 리스트 원소 추가.
			solve(dwarf, i+1, sum+height[i]); // 바뀐 리스트 인자로 넘겨줌.
			dwarf.removeLast(); // 마지막 원소를 제거함으로써 리스트 원상복구.
			if(flag) return ; // 답이 한 번 출력되었다면 메소드 종료.
		}
	}
}