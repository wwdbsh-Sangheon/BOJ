import java.io.*;
import java.util.*;

// 주어진 범위 안에서 4와 7로만 이루어진 수(금민수)의 개수를 찾는 문제.
public class Main{

	private static int a, b, ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		addCount("4", 1); // 4로 시작.
		addCount("7", 1); // 7로 시작.
		System.out.println(ans);
		br.close();
	}

	// number: 금민수, len: 숫자의 길이.
	private static void addCount(String number, int len){

		// 문제에 명시된 가장 큰 범위의 끝이 10억이므로 길이가 10이 되면 재귀탈출.
		if(len == 10){
			return ;
		}

		int num = Integer.parseInt(number);

		// 금민수가 a 보다 크거나 같고 b 보다 작거나 같다면 금민수의 개수를 증가시킨다.
		if(num >= a && num <= b){
			ans++;
		}
		addCount(number+"4", len+1); // 기존 금민수 뒤에 4를 이어 붙이고 메소드 호출.
		addCount(number+"7", len+1); // 기존 금민수 뒤에 7를 이어 붙이고 메소드 호출.
	}
}