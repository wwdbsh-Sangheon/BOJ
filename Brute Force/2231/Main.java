import java.io.*;
import java.util.*;

public class Main{

	private static int n;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		System.out.println(solve(1));
		br.close();
	}

	// m: 생성자
	private static int solve(int m){

		/*
		생성자와 n이 같다면 더 이상 진행할수 없다. 즉, n의 생성자는 없다는 뜻.
		메소드 탈출.
		*/
		if(m == n) return 0;

		int temp = m; // 자기자신
		String num = String.valueOf(m);
	
		for(int i = 0; i < num.length(); i++){

			temp += Integer.parseInt(num.substring(i, i+1)); // 각 자릿수를 더해준다.
		}

		return (temp == n) ? m : solve(m+1); // temp과 n이 같다면 생성자 리턴. 아닐시 기존 생성자에 1을 더해준후 메소드 재귀호출.
	}
}