import java.io.*;
import java.util.*;

public class Main{

	private static int[] numbers;
	private static int n;
	/*
	수학적인 사고가 필요한 문제.
	a1 = k1*M + m
	a2 = k2*M + m
	...
	an = kn*M + m
	a2-a1 = (k2-k1)*M
	...
	an-an-1 = (kn-kn-1)*M
	인접한 수들의 차이의 최대공약수는 제시된 수들의 나눴을때 같은 나머지를 가지게 한다.
	즉, 구해진 최대공약수의 약수 집합이 답이 된다.
	*/
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		for(int i = 0; i < n; i++){
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers); // 인접한 값들의 차를 구하기 위해 정렬.

		int gcd = numbers[1] - numbers[0];

		for(int i = 2; i < n; i++){
			gcd = gcd(gcd, numbers[i] - numbers[i-1]); // 최대공약수 도출(유클리드 호제법)
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 2; i <= gcd; i++){
			if(gcd % i == 0){ // 약수 검출.
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	// 유클리드 호제법.
	private static int gcd(int x, int y){

		if(x % y == 0)
			return y;
		return gcd(y, x % y);
	}
}