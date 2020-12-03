import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		for(int i = 0; i < 5; i++){
			int score = Integer.parseInt(br.readLine());
			if(score < 40){
				total += 40;
			}else{
				total += score;
			}
		}
		System.out.println(total/5);
		br.close();
	}
}