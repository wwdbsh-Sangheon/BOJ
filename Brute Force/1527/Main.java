import java.io.*;
import java.util.*;

public class Main{

	private static int a, b, ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		addCount("4", 1);
		addCount("7", 1);
		System.out.println(ans);
		br.close();
	}

	private static void addCount(String number, int len){

		if(len == 10){
			return ;
		}

		int num = Integer.parseInt(number);

		if(num >= a && num <= b){
			ans++;
		}
		addCount(number+"4", len+1);
		addCount(number+"7", len+1);
	}
}