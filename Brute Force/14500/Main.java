import java.io.*;
import java.util.*;

public class Main{

	private static int[][] paper;
	private static boolean[][] chk;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, m, max = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		chk = new boolean[n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 완전탐색.
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				chk[i][j] = true;
				dfs(i, j, paper[i][j], 1); // 산모양의 마지막 타입을 제외한 모든 결과 탐색.
				chk[i][j] = false;

				/*
				dfs로 탐색이 안되는 산모양 예외적으로 처리.
				현 위치가 종이에서 각각의 모서리에 위치할땐 해당안됨.
				*/
				if(!(i == 0 && j == 0) && !(i == 0 && j == m-1) && 
					!(i == n-1 && j == 0) && !(i == n-1 && j == m-1)){

					int temp = paper[i][j];

					// 현 위치의 상하좌우 더해줌.
					for(int k = 0; k < 4; k++){
						
						int ax = i + dx[k];
						int ay = j + dy[k];

						if(ax >= 0 && ax < n && ay >= 0 && ay < m)
							temp += paper[ax][ay];
					}

					/*
					현위치가 종이의 끝쪽에 위치해 있을 경우는 상하좌우 중 3개만
					더해진다. 즉, 바로 비교해주면됨.
					*/
					if(i == 0 || j == 0 || i == n-1 || j == m-1){
						
						max = Math.max(max, temp);
					}
					else{
						/*
						현위치가 종이의 끝쪽에 위치해 있지 않을 경우,
						상하좌우 모두 더해졌기 때문에 temp에 하나식 빼가며
						비교해준다.
						*/
						for(int k = 0; k < 4; k++){

							int ax = i + dx[k];
							int ay = j + dy[k];

							temp -= paper[ax][ay]; // 빼준후 비교해준다.
							max = Math.max(max, temp);
							temp += paper[ax][ay]; // 다른 타입을 위해 다시 원상복구 시켜준다.
						}
					}
				}
			}
		}
		System.out.println(max);
		br.close();
	}

	/*
	마지막 도형 타입을 제외한 모든 도형을 탐색하기 위한 dfs.
	x: x좌표, y: y좌표, sum: 누적합, c: 사용된 정사각형의 갯수
	*/
	private static void dfs(int x, int y, int sum, int c)
	{
		// 정사각형의 갯수가 4개가 되면 최댓값 비교 후, 메소드 탈출.
		if(c == 4){
			max = Math.max(max, sum);
			return ;
		}

		for(int i = 0; i < 4; i++){
			
			int ax = x + dx[i];
			int ay = y + dy[i];

			if(ax >= 0 && ax < n && ay >= 0 && ay < m){
				
				if(!chk[ax][ay]){
					chk[ax][ay] = true;
					dfs(ax, ay, sum + paper[ax][ay], c+1);
					chk[ax][ay] = false; // 완전탐색을 위해 원상복구.
				}
			}
		}
	}
}