import java.io.*;
import java.util.*;

public class Main{

	private static int r, b, l, w;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		// 넓이가 제곱근으로 나누어 떨어지면 정사각형이란 의미이므로 l, w 모두 제곱근 값으로 지정.
		if(Math.sqrt(r+b) - (int)Math.sqrt(r+b) == 0.0){
			l = w = (int)Math.sqrt(r+b);
		}else{
			// i: 갈색 타일 집합의 세로 길이. (b/i): 갈색 타일 집합의 가로 길이.
			for(int i = 1; i <= b; i++){
				// b(갈색 타일 집합의 넓이)가 i로 나누어 떨어지면 세로 길이가 i 일때 갈색 타일의 감싸고 있는 빨간색 타일의 개수와 주어진 빨간색 타일의 개수가 일치하는지 확인.
				if(b % i == 0){
					// 갈색 타일을 둘러싸고 있는 빨간색 타일의 개수: 가로(b/i)*2 + 세로(i)*2 + 4.
					if((b/i)*2 + i*2 + 4 == r){
						w = i+2;
						l = (b/i)+2;
						break;
					}
				}
			}
		}
		System.out.println(l + " " + w);
		br.close();
	}
}