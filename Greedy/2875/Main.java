import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		while(k != 0){
			// 여학생 수의 반이 남학생 수 보다 작지 않다면 여학생 수 감소.
			if(n / 2 >= m){
				n--;
			}else{ // 아니면 남학생 수 감소.
				m--;
			}
			k--;
		}
		System.out.println(Math.min(n/2, m));
		br.close();
	}
}