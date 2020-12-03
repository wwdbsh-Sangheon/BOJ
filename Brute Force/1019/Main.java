import java.io.*;
import java.util.*;

public class Main{

	private static int[] counts = new int[10];
	private static int n;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int count = 1;
		int start = 1;

		while(start <= n){

			// 책 끝페이지 변수의 끝자리 9로 만들기.
			while(n % 10 != 9 && start <= n){
				plusCount(n, count);
				n--;
			}

			if(start > n) break;

			// 책 첫페이지 변수의 끝자리 0으로 만들기.
			while(start % 10 != 0 && start <= n){
				plusCount(start, count);
				start++;
			}

			start /= 10;
			n /= 10;

			for(int i = 0; i < 10; i++){
				counts[i] += (n - start + 1) * count;
			}
			count *= 10; // 자릿수가 늘어나면, count 또한 10배 늘어난다.
		}
		
		for(int i = 0; i < 10; i++){
			System.out.print(counts[i] + " ");
		}
		System.out.println();
		br.close();
	}

	private static void plusCount(int num, int count){

		while(num > 0){
			counts[num % 10] += count; // 각 자릿수 숫자 횟수 더해줌.
			num /= 10;
		}
	}
}