import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(st.nextToken());
			if(num < x){
				System.out.print(num + " ");
			}
		}
		System.out.println();
		br.close();
	}
}