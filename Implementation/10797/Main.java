import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String day = br.readLine();
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++){
			String car = st.nextToken();
			if(day.charAt(day.length()-1) == car.charAt(car.length()-1)){
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}