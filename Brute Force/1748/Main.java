import java.io.*;
import java.util.*;

// 쉬어가는 느낌으로 풀은 문제. 그냥 전부 탐색했다.
public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());

		int ans = 0, start = 1;

		if(number == 100000000){
			ans += 9;
			ans += 8 * 90000000;
			ans += 7 * 9000000;
			ans += 6 * 900000;
			ans += 5 * 90000;
			ans += 4 * 9000;
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 100000001;
		}else if(number > 99999999){
			ans += 8 * 90000000;
			ans += 7 * 9000000;
			ans += 6 * 900000;
			ans += 5 * 90000;
			ans += 4 * 9000;
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 100000000;
		}else if(number > 9999999){
			ans += 7 * 9000000;
			ans += 6 * 900000;
			ans += 5 * 90000;
			ans += 4 * 9000;
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 10000000;
		}else if(number > 999999){
			ans += 6 * 900000;
			ans += 5 * 90000;
			ans += 4 * 9000;
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 1000000;
		}else if(number > 99999){
			ans += 5 * 90000;
			ans += 4 * 9000;
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 100000;
		}else if(number > 9999){
			ans += 4 * 9000;
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 10000;
		}else if(number > 999){
			ans += 3 * 900;
			ans += 2 * 90;
			ans += 1 * 9;
			start = 1000;
		}else if(number > 99){
			ans += 2 * 90;
			ans += 1 * 9;
			start = 100;
		}else if(number > 9){
			ans += 1 * 9;
			start = 10;
		}

		for(int i = start; i <= number; i++){
			if(i >= 1 && i <= 9) ans++;
			else if(i >= 10 && i <= 99) ans += 2;
			else if(i >= 100 && i <= 999) ans += 3;
			else if(i >= 1000 && i <= 9999) ans += 4;
			else if(i >= 10000 && i <= 99999) ans += 5;
			else if(i >= 100000 && i <= 999999) ans += 6;
			else if(i >= 1000000 && i <= 9999999) ans += 7;
			else if(i >= 10000000 && i <= 99999999) ans += 8;
			else ans += 9;
		}
		System.out.println(ans);
		br.close();
	}
}