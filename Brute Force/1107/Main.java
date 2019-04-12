import java.io.*;
import java.util.*;

public class Main{

	private static int[] button = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static int n, m, ans;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ans = Math.abs(n - 100); // 처음 보고 있던 채널에서 +,-로 채널을 맞춘 경우.
		if(m != 0){ // 고장난 버튼이 있을 경우.
			st = new StringTokenizer(br.readLine());
			// 고장난 버튼 -1로 표시.
			for(int i = 0; i < m; i++) button[Integer.parseInt(st.nextToken())] = -1;
			solve("", 0);
		}else{ // 고장난 버튼이 없을 경우. 기존 ans와 원하는 채널의 길이 중 최솟값 도출.
			ans = Math.min(ans, String.valueOf(n).length());
		}
		System.out.println(ans);
		br.close();
	}

	// input: 리모콘으로 입력한 숫자, count: 리모콘 버튼을 누른 횟수(숫자버튼)
	private static void solve(String input, int count){

		/*
		n값에 상관없이 모든 경우의 수를 전부 따져준다.
		10만자리수가 넘어가거나, 2자리 이상 일때 0으로 시작하면 메소드 탈출.
		시간제한이 2초이고, 최대 경우의 수가 1초 안에 해결가능하므로 가능.
		*/
		if(input.length() > 6 || (input.length() > 1 && input.charAt(0) == '0')) return ;

		// 리모콘 버튼 순회.
		for(int i = 0; i < 10; i++){
			if(button[i] == -1) continue; // 고장난 버튼이면 스킵.
			if(input.equals("")){ // 아직 아무 버튼도 누르지 않았을때.
				input = String.valueOf(i);
				ans = Math.min(ans, Math.abs(n-i)+1);
				solve(input, count+1);
				input = "";
			}else{ // 버튼을 눌렀을때.
				input += String.valueOf(i); // 기존에 눌렀던 버튼 뒤에 이어서 삽입.
				ans = Math.min(ans, Math.abs(n - Integer.parseInt(input))+count+1); // 기존의 누른 버튼수와 새로운 값(누른 버튼수 + 누른 버튼에서 +/- 계산한값) 사이 최솟값 도출.
				solve(input, count+1);
				input = input.substring(0, input.length()-1);
			}
		}
	}
}