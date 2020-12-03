import java.io.*;
import java.util.*;
// 30의 배수가 될 조건: 가장 끝자리 수가 0이어야함, 각 자릿수 합이 3의 배수가 되어야함.
public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> digit = new ArrayList<String>();
		char[] n = br.readLine().toCharArray();
		int sum = 0, flag = -1;
		for(int i = 0; i < n.length; i++){
			if(n[i] == '0'){
				flag = 0;
			}
			sum += n[i] - '0';
			digit.add(String.valueOf(n[i]));
		}

		/* 
		주어진 숫자가 0을 포함하지 않거나 각 자릿수들의 합이 3의 배수가 아니면 -1 출력.
		아니면, 주어진 숫자를 내림차순 정렬 후 출력.
		*/
		if(sum % 3 != 0 || flag == -1){
			System.out.println(-1);
		}else{
			Collections.sort(digit, Collections.reverseOrder());
			for(String d : digit){
				System.out.print(d);
			}
			System.out.println();
		}
		br.close();
	}
}