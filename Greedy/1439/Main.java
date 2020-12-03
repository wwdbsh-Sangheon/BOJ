import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int one = 0;
		int zero = 0;
		// 1 덩어리 0 덩어리 센 다음 작은 개수 출력.
		if(s.charAt(0) == '0') zero++;
		else one++;
		
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i-1) != s.charAt(i)){
				if(s.charAt(i) == '0'){
					zero++;
				}else{
					one++;
				}
			}
		}
		System.out.println(Math.min(zero, one));
		br.close();
	}
}