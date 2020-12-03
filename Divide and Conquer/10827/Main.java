import java.io.*;
import java.util.*;
import java.math.*;
// 일반적인 실수값을 계산하는 pow는 근사값을 반환. 하지만 BigDecimal은 정수값을 이용해서 실수값을 나타내기 때문에 정확한 값을 반환.
public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		BigDecimal a = new BigDecimal(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		a = a.pow(b);
		System.out.println(a.toPlainString()); // 소수점 자리가 10자리를 넘어가면 1e... 형태를 반환하기 때문에 문자열 형태의 값으로 출력.
	}
}