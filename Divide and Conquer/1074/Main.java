import java.io.*;
import java.util.*;

public class Main{

	private static int n, r, c, p = 0, flag = 0; // p: 배열을 순회할 포인터 변수, flag: 재귀호출을 제어할 변수.

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		Z(0, 0, (int)Math.pow(2, n)/2);
		System.out.println(p);
		br.close();
	}

	// x: x좌표, y: y좌표, half: 탐색 범위를 반으로 나눠줄 변수.
	private static void Z(int x, int y, int half){

		// 포인터의 위치가 (r, c)라면 재귀탈출.
		if(flag == 1) return ;
		
		// half 변수가 더 이상 반으로 1이 됨으로써 더 이상 반으로 나눠지지 않으면 포인터 변수 증가 후 재귀탈출.
		if(half == 1){

			// 포인터 변수가 (r, c)라면 flag = 1 후 재귀탈출.
			if(x == r && y == c){
				flag = 1;
				return ;
			}
			
			p++;
			
			if(x == r && y+1 == c){
				flag = 1;
				return ;
			}
			
			p++;
			
			if(x+1 == r && y == c){
				flag = 1;
				return ;
			}
			
			p++;
			
			if(x+1 == r && y+1 == c){
				flag = 1;
				return ;
			}
			
			p++;
			
			return ;
		}

		// 탐색 범위를 4부분으로 나눈 후 Z 진행방향으로 메소드 호출.
		Z(x, y, half/2);
		Z(x, y+half, half/2);
		Z(x+half, y, half/2);
		Z(x+half, y+half, half/2);
	}
}