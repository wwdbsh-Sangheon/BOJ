import java.io.*;
import java.util.*;

public class Main{

	private static boolean[][] chk;
	private static int[] dx = {-1, 0, 1}; // 진행순서: 대각선위, 오른쪽, 대각선아래
	private static int[] dy = {1, 1, 1};
	private static int r, c, ans = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		chk = new boolean[r][c];
		for(int i = 0; i < r; i++){
			String row = br.readLine();
			for(int j = 0; j < c; j++){
				if(row.charAt(j) == 'x'){
					chk[i][j] = true;
				}
			}
		}

		for(int i = 0; i < r; i++){
			if(setPipe(i, 0)) ans++;
		}
		System.out.println(ans);
		br.close();
	}

	// 그리디하게 접근. 한쪽 방향 진행. 이미 지나간 곳은 확인할 필요 없음.
	private static boolean setPipe(int x, int y){

		chk[x][y] = true;

		if(y == c - 1) return true;

		for(int i = 0; i < 3; i++){

			int ax = x + dx[i];
			int ay = y + dy[i];

			if(ax >= 0 && ay >= 0 && ax < r && ay < c && !chk[ax][ay]){
				if(setPipe(ax, ay)){
					return true;
				}
			}
		}
		return false;
	}
}