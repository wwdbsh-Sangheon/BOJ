import java.io.*;
import java.util.*;

public class Main{

	private static int change, ans = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		change = 1000 - Integer.parseInt(br.readLine());

		while(change != 0){
			if(change >= 500){
				change -= 500;
			}else if(change >= 100){
				change -= 100;
			}else if(change >= 50){
				change -= 50;
			}else if(change >= 10){
				change -= 10;
			}else if(change >= 5){
				change -= 5;
			}else{
				change--;
			}
			ans++; // 동전 개수 증가.
		}
		System.out.println(ans);
		br.close();
	}
}