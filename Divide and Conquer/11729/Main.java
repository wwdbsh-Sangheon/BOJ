import java.io.*;
import java.util.*;

public class Main{

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		hanoi(1, 3, n);
		System.out.println((int)Math.pow(2, n) - 1); // 옮긴 횟수. 
		System.out.print(sb.toString());
		br.close();
	}

	// a: from, b: to, n: 옮길 원판의 개수.
	private static void hanoi(int a, int b, int n){

		// 옮길 원판의 수가 1개면 a에서 b로 옮긴다.(n-1개의 원판은 a와 b가 아닌 나머지 한개의 기둥으로 이미 옮겨져 있으므로 항상 성립한다.)
		if(n == 1){
			sb.append(a + " " + b + "\n");
			return ;
		}

		// a에 위치한 n개의 원판의 가장 아래에 위치한 원판을 b로 옮기기 위해선 n-1개의 원판이 a와 b가 아닌 나머지 한개의 원판으로 옮겨져야한다.
		hanoi(a, 6 - a - b, n-1);
		sb.append(a + " " + b + "\n");
		// n번째 원판이 b로 옮겨졌으면 나머지 n-1개의 원판도 b로 옮겨져야한다.
		hanoi(6 - a - b, b, n-1);
	}
}