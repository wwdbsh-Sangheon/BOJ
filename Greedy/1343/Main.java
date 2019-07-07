import java.io.*;
import java.util.*;

public class Main{

	private static StringBuilder sb = new StringBuilder();
	private static int count = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String board = br.readLine();

		for(int i = 0; i < board.length(); i++){
			if(board.charAt(i) == 'X'){
				count++;
			}else{
				cover();
				if(sb.toString().equals("-1")) break;
				sb.append('.');
			}
		}
		cover();
		System.out.println(sb.toString());
		br.close();
	}

	private static void cover(){

		while(count > 1){
			// X의 개수가 4이상이면 AAAA 덮어주기.
			if(count >= 4){
				sb.append("AAAA");
				count -= 4;
			// X의 개수가 2이상이면 BB 덮어주기.
			}else if(count >= 2){
				sb.append("BB");
				count -= 2;
			}
		}
		// 남은 X의 개수가 1개면 폴리노미오로 덮기 불가능.
		if(count == 1){
			sb.delete(0, sb.length());
			sb.append("-1");
			count--;
		}
	}
}