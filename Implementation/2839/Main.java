import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), ans = 0;

		while(true){

			if(n % 5 == 0){
				System.out.println(n/5 + ans);
				break;
			}else if(n <= 0){
				System.out.println(-1);
				break;
			}
			n -= 3;
			ans++;

		}
		br.close();
	}
}