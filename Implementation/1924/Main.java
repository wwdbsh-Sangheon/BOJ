import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		for(int i = 1; i < m; i++){
			d += getNumDays(i);
		}
		System.out.println(day[d%7]);
		br.close();
	}

	private static int getNumDays(int m){

		switch(m){

			case 1 :
				return 31;
			case 2 :
				return 28;
			case 3 :
				return 31;
			case 4 :
				return 30;
			case 5 :
				return 31;
			case 6 :
				return 30;
			case 7 :
				return 31;
			case 8 :
				return 31;
			case 9 :
				return 30;
			case 10 :
				return 31;
			case 11 :
				return 30;
		}

		return 31;
	}
}