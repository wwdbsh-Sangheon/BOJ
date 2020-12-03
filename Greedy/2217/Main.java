import java.io.*;
import java.util.*;

public class Main{

	private static int[] ropes;
	private static int n, ans = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ropes = new int[n];
		for(int i = 0; i < n; i++){
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes);
		
		for(int i = 0; i < n; i++){
			// 해당 로프의 무게를 자신 보다 커거나 같은 무게(자신포함)를 들수있는 개수와 곱한 값과 비교.
			if(ans < ropes[i]*(n-i)){
				ans = ropes[i]*(n-i);
			}
		}
		System.out.println(ans);
		br.close();
	}
}