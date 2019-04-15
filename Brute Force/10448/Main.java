import java.io.*;
import java.util.*;

public class Main{

	private static int k, flag = 0; // flag: 메소드의 재귀호출을 탈출하게 해줄 변수.

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0){

			k = Integer.parseInt(br.readLine());
			eureka(0, 0);
			if(flag == 0) System.out.println(0); // flag가 1이 아니라면 0 출력.
			else flag = 0; // flag 초기화.
		}
		br.close();
	}

	// sum: 삼각수들의 합, count: 사용된 삼각수의 수.
	private static void eureka(int sum, int count){

		// 사용된 삼각수의 수가 3개 보다 많거나, 삼각수의 합이 k 보다 크면 재귀 탈출.
		if(count > 3 || sum > k)
			return ;

		// 사용된 삼각수의 수가 3개면 재귀 탈출.
		if(count == 3){
			// 삼각수의 합이 k와 같다면 1 출력 후 flag 체크.
			if(sum == k){
				System.out.println(1);
				flag = 1;
			}
			return ;
		}

		for(int i = 1; i < 45; i++){
			eureka(sum + i*(i+1)/2, count+1);
			if(flag == 1) break; // 반복문 탈출.
		}
	}
}