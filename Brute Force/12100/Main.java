import java.io.*;
import java.util.*;

public class Main{
							 //우,좌,하,상
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
				ans = Math.max(ans, board[i][j]); // 최댓값 갱신.
			}
		}
		dfs(board, 0);
		System.out.println(ans);
		br.close();
	}

	// board: 보드의 상태(갱신된 상태), count: 움직인 횟수
	private static void dfs(int[][] board, int count){

		// 5번 움직였다면 메소드 탈출.
		if(count == 5) return ;

		//상하좌우 움직임을 따지기 위한 반복문.
		for(int i = 0; i < 4; i++){

			// 기존의 보드의 상태를 유지하기 위해 카피 배열을 만들어서 작업한다.(완전탐색을 위해)
			int[][] copy = new int[n][n];
			copyBoard(board, copy); // 보드를 복사한다.
			update(copy, i); // 보드 갱신. 인자로 카피된 보드를 넘겨주고 움직이는 방향의 타입을 인자로 넘겨준다.
			dfs(copy, count+1); // 카피된 보드를 인자로 넘겨주고, 움직인 횟수를 1 증가시킨값을 인자로 넘겨준다.
		}
	}

	/*
	보드 갱신 메소드.
	board: 갱신할 보드, type: 움직일 방향
	*/
	private static void update(int[][] board, int type){

		// 한 번 합쳐진 값이 다시 합쳐지는 것을 방지하기 위한 불린 배열.
		boolean[][] chk = new boolean[n][n];

		switch(type){
			// 오른쪽 이동. 오른쪽 -> 왼쪽 순서
			case 0 :

				for(int i = 0; i < n; i++){
					for(int j = n-1; j >= 0; j--){
						if(board[i][j] == 0) continue;
						move(board, chk, i, j, 0);
					}
				}
				break;
			// 왼쪽 이동. 왼쪽 -> 오른쪽 순서
			case 1 :

				for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						if(board[i][j] == 0) continue;
						move(board, chk, i, j, 1);
					}
				}
				break;
			// 아래쪽 이동. 아래 -> 위 순서
			case 2 :

				for(int i = 0; i < n; i++){
					for(int j = n-1; j >= 0; j--){
						if(board[j][i] == 0) continue;
						move(board, chk, j, i, 2);
					}
				}
				break;
			// 위쪽 이동. 위 -> 아래 순서
			default:

				for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						if(board[j][i] == 0) continue;
						move(board, chk, j, i, 3);
					}
				}
		}
	}

	/*
	보드의 특정한 한개의 값을 움직이는 메소드.
	board: 갱신할 보드, chk: 중복 합산을 방지할 불린 배열, x: x좌표, y: y좌표, type: 움직일 방향
	*/
	private static void move(int[][] board, boolean[][] chk, int x, int y, int type){

		while(true){

			int ax = x + dx[type];
			int ay = y + dy[type];

			// ax, ay가 보드의 범위안에 있고 불린 값이 체크되지 않았을때 전개.
			if(ax >= 0 && ax < n && ay >= 0 && ay < n && !chk[ax][ay]){

				// 현재 위치의 값이 다음 위치의 값과 같을때
				if(board[x][y] == board[ax][ay]){

					board[ax][ay] += board[x][y];
					board[x][y] = 0; // 기존 위치 0으로 갱신.
					chk[ax][ay] = true; // 방문 체크.
					ans = Math.max(ans, board[ax][ay]); // 최댓값 갱신.

				}else if(board[ax][ay] == 0){ // 다음 위치의 값이 0일때

					board[ax][ay] = board[x][y]; // 위치 한칸 이동.
					board[x][y] = 0; // 기존 위치 0으로 갱신.
					x = ax; // x, y 갱신.
					y = ay;
					continue; // 반복문 계속 전개.
				}
			}
			break; // 반복문 탈출
		}
	}

	/*
	배열 복사를 위한 메소드.
	array: 원본 배열, copy: 복사시킬 배열
	*/
	private static void copyBoard(int[][] array, int[][] copy){

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				copy[i][j] = array[i][j];
			}
		}
	}
}