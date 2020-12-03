import java.io.*;
import java.util.*;

public class Main{
	
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static ArrayList<Cctv> cctv = new ArrayList<Cctv>();
	private static int n, m, ans = 987654321;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				// cctv 번호와 위치 저장.
				if(map[i][j] >= 1 && map[i][j] <= 5) cctv.add(new Cctv(map[i][j], i, j));
			}
		}
		dfs(map, 0, 0);
		System.out.println(ans);
		br.close();
	}

	/*
	완전탐색을 위한 dfs
	map: 탐색할 지도, idx: cctv의 순서를 나타내는 색인, count: 감시 방향을 정한 cctv의 수
	*/
	private static void dfs(int[][] map, int idx, int count){

		// 기저 사례: 모든 cctv의 감시 방향을 정했다면, 사각지대 수 카운팅 후 최솟값 도출. 그리고 메소드 탈출.
		if(count == cctv.size()){

			int c = 0;

			// 사각지대 수 체크.
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(map[i][j] == 0) c++;

			ans = Math.min(ans, c); // 최솟값 도출.
			return;
		}

		int[][] copy = new int[n][m]; // 인자로 넘길 복사본.

		for(int i = idx; i < cctv.size(); i++){
	
			copyMap(map, copy); // 지도 복사.
			operate(copy, cctv.get(i), i, count+1);
		}
	}

	/*
	cctv별 작동을 구분할 메소드.
	map: 탐색할 지도, cctv: 작업할 cctv, idx: cctv 순서를 나타낼 색인, count: 감시 방향을 정한 cctv의 수
	*/
	private static void operate(int[][] map, Cctv cctv, int idx, int count){

		int[][] copy = new int[n][m]; // 인자로 넘길 복사본.

		switch(cctv.num){

			case 1 : // cctv 1

				// 한 경우에 한 방향만 체크.
				for(int i = 0; i < 4; i++){

					copyMap(map, copy);
					update(copy, cctv, i);
					dfs(copy, idx+1, count);
				}
				break;

			case 2 : // cctv 2

				// 한 경우에 마주보는 양쪽 방면 체크. <-->
				for(int i = 0; i < 4; i += 2){

					copyMap(map, copy);
					update(copy, cctv, i);
					update(copy, cctv, i+1);
					dfs(copy, idx+1, count);
				}
				break;

			case 3 : // cctv 3

				// 한 경우에 ㄱ자 모양 방향으로 체크.
				for(int i = 0; i < 2; i++){
					for(int j = 2; j < 4; j++){
						copyMap(map, copy);
						update(copy, cctv, i);
						update(copy, cctv, j);
						dfs(copy, idx+1, count);
					}
				}
				break;

			case 4 : // cctv 4

				// 한 경우에 산 모양 방향으로 체크. ㅗ
				for(int i = 0; i < 4; i++){
					copyMap(map, copy);
					for(int j = 0; j < 4; j++){
						if(i == j) continue;
						update(copy, cctv, j);
					}
					dfs(copy, idx+1, count);
				}
				break;

			default: // cctv 5

				// 한 경우 카메라를 둘러싼 상하좌우 전부 체크.
				copyMap(map, copy);
				for(int i = 0; i < 4; i++)
					update(copy, cctv, i);
				dfs(copy, idx+1, count);
		}
	}

	/*
	카메라 작용을 적용할 메소드. 한 번 호출시 한 방향 체크만 가능.
	map: 탐색할 지도, cctv: 작업할 cctv, type: 감시할 방향을 정할 매개변수
	*/
	private static void update(int[][] map, Cctv cctv, int type){

		int x = cctv.x, y = cctv.y;

		while(true){

			x += dx[type];
			y += dy[type];
			// 좌표가 지도 범위 밖을 벗어나거나 벽을 만난다면 반복문 탈출.
			if( x < 0 || x >= n || 
				y < 0 || y >= m ||
				map[x][y] == 6) break;
			// 좌표의 위치가 지도에서 0을 나타낸다면 -1로 갱신.
			if(map[x][y] == 0){
				map[x][y] = -1;
			}
		}
	}

	/*
	지도를 복사하기 위한 메소드.
	map: 원본, copy: 복사본
	*/
	private static void copyMap(int[][] map, int[][] copy){

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				copy[i][j] = map[i][j];
			}
		}
	}

	// cctv를 나타낼 객체를 표현하는 클래스.
	private static class Cctv{

		private int num, x, y;

		private Cctv(int num, int x, int y){

			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
}