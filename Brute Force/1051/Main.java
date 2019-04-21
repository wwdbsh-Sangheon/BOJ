import java.io.*;
import java.util.*;

public class Main{

	private static int[][] rec;
	private static int n, m, ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rec = new int[n][m];
		for(int i = 0; i < n; i++){
			String line = br.readLine();
			for(int j = 0; j < m; j++){
				rec[i][j] = (int)(line.charAt(j) - '0');
			}
		}
		getMaxArea(0, 0, 0);
		System.out.println(ans);
		br.close();
	}

	// x: x좌표, y: y좌표, add: 한 변의 길이에 추가할 수 
	private static void getMaxArea(int x, int y, int add){

		// 좌표가 직사각형의 마지막 지점이라면 1과 최댓값 비교 후 재귀 탈출.
		if(x == n-1 && y == m-1){
			ans = Math.max(ans, 1);
			return ;
		}

		// 정사각형의 한변의 길이가 범위를 벗어난다면 재귀탈출.
		if(x+add >= n || y+add >= m){
			// y좌표가 m과 같다면 y값과 add는 0으로 초기화. 그리고 x값은 1 추가한다.
			if(y == m){
				getMaxArea(x+1, 0, 0);
			}else{ // 아니면 add는 0으로 초기화. 그리고 y값은 1 추가한다.
				getMaxArea(x, y+1, 0);
			}
			return ;
		}

		int digit = rec[x][y]; // 기준이 되는 꼭지점의 값.

		// 나머지 3개의 꼭지점의 값과 같은지 비교 후, 조건이 성립하면 새로운 넓이와 기존의 넓이의 최댓값을 도출한다.
		if(rec[x+add][y] == digit &&
			rec[x][y+add] == digit &&
			rec[x+add][y+add] == digit){
			ans = Math.max(ans, (add+1)*(add+1));
		}
		getMaxArea(x, y, add+1); // 정사각형의 길이를 1 늘려준 후, 재귀 호출.
	}
}